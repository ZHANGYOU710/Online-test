package cn.uu710.controller;

import cn.uu710.domain.AdminInfo;
import cn.uu710.service.AdminInfoService;
import cn.uu710.util.SessionUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/personalcenter/admininfo.do")
public class AdminInfoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminInfoService adminInfoService = new AdminInfoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "detail":
			detail(request, response);
			break;
		case "modifyPassword":
			modifyPassword(request, response);
			break;
		case "enterModifyPassword":
			enterModifyPassword(request, response);
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

	private void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminInfo loginAdminInfo = SessionUtil.getAdminInfoFromSession(request);
		AdminInfo adminInfo = adminInfoService.getByAdminName(loginAdminInfo
				.getAdminName());
		request.setAttribute("admin_info", adminInfo);
		request.getRequestDispatcher("/admin/personalcenter/admin_detail.jsp")
				.forward(request, response);

	}

	private void modifyPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String originalPass = request.getParameter("original_pass");
		String newPass = request.getParameter("new_pass");
		AdminInfo adminInfo = SessionUtil.getAdminInfoFromSession(request);
		try {
			if (!originalPass.equals(adminInfo.getAdminPass())) {
				request.setAttribute("tip_info", "原密码错误");
				request.getRequestDispatcher("/admin/personalcenter/modify_password.jsp").forward(
						request, response);
			} else {
				boolean result = adminInfoService.updatePasswordByAdminName(
						adminInfo.getAdminName(), newPass);
				if (result) {
					request.setAttribute("tip_info", "修改密码成功");
				} else {
					request.setAttribute("tip_info", "修改密码失败");
				}
				request.getRequestDispatcher("/admin/personalcenter/modify_password.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void enterModifyPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"/admin/personalcenter/modify_password.jsp").forward(request,
				response);
	}

	private void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdminInfo adminInfoSession = SessionUtil.getAdminInfoFromSession(request);
		String adminName = request.getParameter("admin_name");
		String adminPhone = request.getParameter("admin_phone");

		AdminInfo adminInfo = new AdminInfo();
		adminInfo.setId(adminInfoSession.getId());
		adminInfo.setAdminName(adminName);
		adminInfo.setAdminPhone(adminPhone);
		boolean result = adminInfoService.update(adminInfo);

		request.getSession().setAttribute("login_admin", adminInfo);
		if (result) {
			request.setAttribute("tip_info", "修改成功");
		} else {
			request.setAttribute("tip_info", "修改失败");
		}

		request.getRequestDispatcher("admininfo.do?action=detail").forward(
				request, response);

	}

	private void enterUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AdminInfo loginAdminInfo = SessionUtil.getAdminInfoFromSession(request);
		AdminInfo adminInfo = adminInfoService.getByAdminName(loginAdminInfo
				.getAdminName());
		request.setAttribute("admin_info", adminInfo);
		request.getRequestDispatcher("/admin/personalcenter/admin_edit.jsp")
				.forward(request, response);
	}

}
