package cn.uu710.util;

import cn.uu710.domain.AdminInfo;
import cn.uu710.domain.StudentInfo;

import javax.servlet.http.HttpServletRequest;



public class SessionUtil {

	public static AdminInfo getAdminInfoFromSession(HttpServletRequest request) {
		return (AdminInfo) request.getSession().getAttribute("login_admin");
	}

	public static StudentInfo getStudentInfoFromSession(
			HttpServletRequest request) {
		return (StudentInfo) request.getSession().getAttribute("login_student");
	}

}
