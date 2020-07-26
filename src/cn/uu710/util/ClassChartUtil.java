package cn.uu710.util;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.uu710.service.StudentInfoService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



public class ClassChartUtil {
	private StudentInfoService studentInfoService = new StudentInfoService();

	public JFreeChart createPieChart() {
		// 解决中文乱码开始
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
		JFreeChart pieChart = ChartFactory.createPieChart3D("分班情况",
		// 标题
				initPieData(),// 数据
				true,// 是否显示图例
				true,// 是否显示工具提示
				false// 是否生成URL
				);
		pieChart.getTitle().setFont(new Font("隶书", Font.BOLD, 25));
		pieChart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		PiePlot plot = (PiePlot) pieChart.getPlot();
		// 获得饼图的Plot对象
		// plot.setLabelFont(new Font("宋体", Font.PLAIN, 12));//
		// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位//
		// plot.setLabelGenerator(new
		// StandardPieSectionLabelGenerator("{0}：{1}({2})",
		// NumberFormat.getNumberInstance(),//new DecimalFormat("0.00%")));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}：{2}",
				NumberFormat.getNumberInstance(), NumberFormat
						.getPercentInstance()));
		return pieChart;
	}

	public String generatePieChart(HttpSession session, PrintWriter pw) {
		String filename = null;
		JFreeChart chart = createPieChart();
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {// saveChartAsPNG生成PNG图片,并返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
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
	
	public String generatePieChart(File file) {
		JFreeChart chart = createPieChart();
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {// saveChartAsPNG生成PNG图片,并返回文件名
			ChartUtils.saveChartAsJPEG(file, chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PieDataset initPieData() {
		// 设置数据
		DefaultPieDataset dataset = new DefaultPieDataset();
		Map<Integer, Integer> map = studentInfoService.getPeopleByClass();
		for (Map.Entry entry : map.entrySet()) {
			Integer classId = (Integer) entry.getKey();
			Integer peopleNum = (Integer) entry.getValue();
			if (classId == 1) {
				dataset.setValue("火箭班", peopleNum);
			}
			if (classId == 2) {
				dataset.setValue("进阶班", peopleNum);
			}
			if (classId == 3) {
				dataset.setValue("基础班", peopleNum);
			}
		}

		return dataset;
	}
}
