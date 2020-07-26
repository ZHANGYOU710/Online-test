package cn.uu710.controller;

import cn.uu710.domain.ClassInfo;
import cn.uu710.domain.StudentInfo;
import cn.uu710.service.ClassInfoService;
import cn.uu710.service.StudentAnswerService;
import cn.uu710.service.StudentInfoService;
import cn.uu710.util.SessionUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/student/queryinfo.do")
public class StudentQueryInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentAnswerService answerService = new StudentAnswerService();
	private StudentInfoService studentInfoService = new StudentInfoService();
	private ClassInfoService classInfoService = new ClassInfoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentInfo studentInfo = SessionUtil.getStudentInfoFromSession(request);
		int totalScore = answerService.getScore(studentInfo.getStudentNum());
		request.setAttribute("totalScore", totalScore);
		StudentInfo realStudentInfo = studentInfoService.getById(studentInfo
				.getId());
		ClassInfo classInfo = classInfoService.getById(realStudentInfo
				.getClassId());
		if(null!=classInfo){
			request.setAttribute("class_name", classInfo.getClassName());
		}
		request.setAttribute("stu_info", realStudentInfo);
		request.getRequestDispatcher("/student/info/query_info.jsp").forward(request,
				response);
	}

}
