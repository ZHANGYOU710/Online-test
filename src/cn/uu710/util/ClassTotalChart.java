package cn.uu710.util;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import cn.uu710.domain.ClassInfo;
import cn.uu710.service.ClassInfoService;
import cn.uu710.service.StudentInfoService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



public class ClassTotalChart {
	private StudentInfoService studentInfoService=new StudentInfoService();
	private ClassInfoService classInfoService=new ClassInfoService();

	
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
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}：{2}",
				NumberFormat.getNumberInstance(), NumberFormat
						.getPercentInstance()));
		return pieChart;
	}
	
	public PieDataset initPieData() {
		// 设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
		//设置数据
		//获取所有班级
		List<ClassInfo> classList=classInfoService.findAll();
		Map<Integer, Integer> map=studentInfoService.getPeopleByClass();
		for (Map.Entry entry : map.entrySet()) {
			Integer classId = (Integer) entry.getKey();
			Integer peopleNum = (Integer) entry.getValue();
			for(ClassInfo classInfo:classList){
				if(classId==classInfo.getId()){
					dataset.setValue(classInfo.getClassName(), peopleNum);
					continue;
				}
				
			}
		}
		return dataset;
	}
	
	public String generatePieChart(File file) {
		//创建图
		JFreeChart chart = createPieChart();
		//保存图片
		try {// saveChartAsPNG生成PNG图片,并返回文件名
			ChartUtils.saveChartAsJPEG(file, chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}