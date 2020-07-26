package cn.uu710.controller;

import cn.uu710.domain.AdminInfo;
import cn.uu710.domain.ClassInfo;
import cn.uu710.service.ClassInfoService;
import cn.uu710.util.SessionUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/class/classinfo.do")
public class ClassInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoService classInfoService = new ClassInfoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "findAll":
			findAll(request, response);
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
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ClassInfo> list = classInfoService.findAll();
		request.setAttribute("class_list", list);
		request.getRequestDispatcher("/admin/class/class_list.jsp").forward(
				request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String className = request.getParameter("class_name");
		String maxScore = request.getParameter("max_score");
		String minScore = request.getParameter("min_score");
		String classRule = request.getParameter("class_rule");

		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassName(className);
		classInfo.setMaxScore(Integer.valueOf(maxScore));
		classInfo.setMinScore(Integer.valueOf(minScore));
		classInfo.setCreateTime(new Date());
		classInfo.setClassRule(classRule);
		AdminInfo adminInfo = SessionUtil.getAdminInfoFromSession(request);
		classInfo.setCreator(adminInfo.getId());
		classInfo.setOperator(adminInfo.getId());
		boolean result = classInfoService.add(classInfo);
		if (result) {
			request.setAttribute("tip_info", "添加班级成功");
		} else {
			request.setAttribute("tip_info", "添加班级失败");
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	private void enterAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/class/class_add.jsp").forward(
				request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		boolean result = classInfoService.delete(id);
		if (result) {
			request.setAttribute("tip_info", "删除班级成功");
		} else {
			request.setAttribute("tip_info", "删除班级失败");
		}
		request.getRequestDispatcher("classinfo.do?action=findAll").forward(
				request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String className = request.getParameter("class_name");
		String maxScore = request.getParameter("max_score");
		String minScore = request.getParameter("min_score");

		ClassInfo classInfo = new ClassInfo();
		classInfo.setId(id);
		classInfo.setClassName(className);
		classInfo.setMaxScore(Integer.valueOf(maxScore));
		classInfo.setMinScore(Integer.valueOf(minScore));
		AdminInfo adminInfo = SessionUtil.getAdminInfoFromSession(request);
		classInfo.setOperator(adminInfo.getId());
		boolean result = classInfoService.update(classInfo);

		if (result) {
			request.setAttribute("tip_info", "修改班级成功");
		} else {
			request.setAttribute("tip_info", "修改班级失败");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	private void enterUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		ClassInfo classInfo = classInfoService.getById(id);
		request.setAttribute("class_info", classInfo);
		request.getRequestDispatcher("/admin/class/class_edit.jsp").forward(
				request, response);
	}
}
