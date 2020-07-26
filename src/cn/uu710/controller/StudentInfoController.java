package cn.uu710.controller;

import cn.uu710.constant.Constants;
import cn.uu710.domain.AdminInfo;
import cn.uu710.domain.MajorInfo;
import cn.uu710.domain.StudentAnswer;
import cn.uu710.domain.StudentInfo;
import cn.uu710.service.MajorInfoService;
import cn.uu710.service.StudentAnswerService;
import cn.uu710.service.StudentInfoService;
import cn.uu710.util.SessionUtil;
import cn.uu710.vo.PageVO;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/student/studentinfo.do")
public class StudentInfoController extends HttpServlet {

	private StudentAnswerService studentAnswerService=new StudentAnswerService();

	private StudentInfoService studentInfoService = new StudentInfoService();

	private MajorInfoService majorInfoService = new MajorInfoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "search":
			search(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "enter_add":
			enterAdd(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "enter_update":
			enterUpdate(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	


	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strPage = request.getParameter("page");
		int page = 1;
		if (null != strPage && !strPage.equals("")) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		PageVO<StudentInfo> pageVO = studentInfoService.search(page,
				Constants.RECORD_OF_PAGE);
		request.setAttribute("page_vo", pageVO);
		request.getRequestDispatcher("/admin/student/student_list.jsp").forward(
				request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentNum = request.getParameter("student_num");
		String studentName = request.getParameter("student_name");
		String studentPassWord = request.getParameter("student_password");
		String studentGender = request.getParameter("student_gender");
		String studentPhone = request.getParameter("student_phone");
		String studentProvince = request.getParameter("student_province");
		String majorInfoId = request.getParameter("major_info_id");

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentNum(Integer.valueOf(studentNum));
		studentInfo.setStudentName(studentName);
		studentInfo.setStudentPassWord(studentPassWord);
		
		studentInfo.setStudentGender(Integer.valueOf(studentGender));
		studentInfo.setStudentPhone(studentPhone);
		studentInfo.setStudentProvince(studentProvince);
		studentInfo.setMajorInfoId(Integer.valueOf(majorInfoId));
		AdminInfo adminInfo = SessionUtil.getAdminInfoFromSession(request);
		studentInfo.setCreator(adminInfo.getId());
		studentInfo.setOperator(adminInfo.getId());
		studentInfo.setCreateTime(new Date());

		boolean result = studentInfoService.add(studentInfo);
		if (result) {
			request.setAttribute("tip_info", "添加学生信息成功");
		} else {
			request.setAttribute("tip_info", "添加学生信息失败");
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	private void enterAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<MajorInfo> list = majorInfoService.findAll();
		request.setAttribute("major_list", list);
		request.getRequestDispatcher("/admin/student/student_add.jsp").forward(request,
				response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		int id = Integer.valueOf(request.getParameter("id"));
		boolean result = studentInfoService.delete(id);
		if (result) {
			request.setAttribute("tip_info", "删除学生信息成功");
		} else {
			request.setAttribute("tip_info", "删除学生信息失败");
		}

		request.getRequestDispatcher("studentinfo.do?action=search&page=1")
				.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		String studentNum = request.getParameter("student_num");
		String studentName = request.getParameter("student_name");
		String studentPassWord = request.getParameter("student_password");
		String studentGender = request.getParameter("student_gender");
		String studentPhone = request.getParameter("student_phone");
		String studentProvince = request.getParameter("student_province");
		String majorInfoId = request.getParameter("major_info_id");

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setId(id);
		studentInfo.setStudentNum(Integer.valueOf(studentNum));
		studentInfo.setStudentName(studentName);
		studentInfo.setStudentPassWord(studentPassWord);

		studentInfo.setStudentGender(Integer.valueOf(studentGender));
		studentInfo.setStudentPhone(studentPhone);
		studentInfo.setStudentProvince(studentProvince);
		studentInfo.setMajorInfoId(Integer.valueOf(majorInfoId));
		AdminInfo adminInfo = SessionUtil.getAdminInfoFromSession(request);
		studentInfo.setOperator(adminInfo.getId());
		boolean result = studentInfoService.update(studentInfo);

		if (result) {
			request.setAttribute("tip_info", "修改学生信息成功");
		} else {
			request.setAttribute("tip_info", "修改学生信息失败");
		}

		request.getRequestDispatcher("/result.jsp")
				.forward(request, response);
	}

	private void enterUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));

		StudentInfo studentInfo = studentInfoService.getById(id);

		request.setAttribute("student_info", studentInfo);

		List<MajorInfo> list = majorInfoService.findAll();
		request.setAttribute("major_list", list);

		request.getRequestDispatcher("/admin/student/student_edit.jsp").forward(request,
				response);
	}

	
}
