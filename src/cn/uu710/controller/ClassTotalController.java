package cn.uu710.controller;

import cn.uu710.util.ClassTotalChart;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/classtotal.do")
public class ClassTotalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClassTotalChart classTotalChart=new ClassTotalChart();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义文件名
		String fileName=request.getServletContext().getRealPath("/")+"/admin/total/class_chart.png";
		//生成图片
		classTotalChart.generatePieChart(new File(fileName));
		request.setAttribute("chart_url", request.getContextPath()+"/admin/total/class_chart.png");
		request.getRequestDispatcher("/admin/total/class_chart.jsp").forward(request, response);
	}


}
