package cn.uu710.util;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import cn.uu710.service.StudentInfoService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;



public class ScoreChartUtil {
	private StudentInfoService studentInfoService=new StudentInfoService();
	
	public  DefaultCategoryDataset initCategoryData() {
		int youxiuPeople=studentInfoService.getPeopleNumberByArea(90,100);
		int lianghaoPeople=studentInfoService.getPeopleNumberByArea(75,89);
		int jigePeople=studentInfoService.getPeopleNumberByArea(60,74);
		int bujigePeople=studentInfoService.getPeopleNumberByArea(0,59);
		// 设置数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 添加数据
		
		dataset.addValue(youxiuPeople, "优秀", "90以上");
		dataset.addValue(lianghaoPeople, "良好", "75-90");
		dataset.addValue(jigePeople, "及格", "60-74");
		dataset.addValue(bujigePeople, "不及格", "0-59");
		return dataset;
	}

	public  JFreeChart createBarChart() {
		//解决中文乱码开始
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		//解决中文乱码结束
		return ChartFactory.createBarChart("学生成绩统计图", "", "人数",
				initCategoryData(), PlotOrientation.VERTICAL, true, false,
				false);

	}
	

	public  String generateBarChart(HttpSession session, PrintWriter pw) {
		String filename = null;
		JFreeChart chart = createBarChart();
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {// saveChartAsPNG生成PNG图片,并返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 700, 400, info,
					session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ChartUtils.writeImageMap(pw, filename, info, false);// 将生成的图片写入到输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.flush();
		return filename;
	}
	
	
}
