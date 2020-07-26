package cn.uu710.controller;

import cn.uu710.domain.StudentInfo;
import cn.uu710.service.StudentInfoService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studentlogin.do")
public class StudentLoginController extends HttpServlet {

	private StudentInfoService service =new StudentInfoService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String studentNum=request.getParameter("student_num");
		String studentPassword=request.getParameter("student_password");
		StudentInfo studentInfo=service.getStudentByStudentNumAndPass(Integer.parseInt(studentNum), studentPassword);
		if(studentInfo!=null){
			request.getSession().setAttribute("login_student", studentInfo);
			request.getRequestDispatcher("/indextest.jsp").forward(request, response);
		}else{
			request.setAttribute("tip_info", "学号或者密码错误");
			request.getRequestDispatcher("/student_login.jsp").forward(request, response);
		}
	}

}