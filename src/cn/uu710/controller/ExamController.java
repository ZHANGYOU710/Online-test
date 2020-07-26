package cn.uu710.controller;

import cn.uu710.domain.PaperInfo;
import cn.uu710.domain.StudentInfo;
import cn.uu710.service.PaperInfoService;
import cn.uu710.service.StudentAnswerService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/student/exam.do")
public class ExamController extends HttpServlet {
	private StudentAnswerService studentAnswerService=new StudentAnswerService();
	private PaperInfoService paperInfoService=new PaperInfoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session获取学员信息
		StudentInfo studentInfo=(StudentInfo) request.getSession().getAttribute("login_student");
		//判断学员是否答过题
		boolean exist=studentAnswerService.existByStudentNum(studentInfo.getStudentNum());
		if(exist){
			request.setAttribute("tip_info", "您已经参与过测试，不允许重复测试");
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			List<PaperInfo> list=paperInfoService.findAll();
			request.setAttribute("paper_list", list);
			request.getRequestDispatcher("/student/index.jsp").forward(request, response);
		}
		
	}

}

