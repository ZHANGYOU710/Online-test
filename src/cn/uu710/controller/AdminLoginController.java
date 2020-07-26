package cn.uu710.controller;

import cn.uu710.domain.AdminInfo;
import cn.uu710.service.AdminInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminlogin.do")
public class AdminLoginController extends HttpServlet {
    private AdminInfoService service = new AdminInfoService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取用户名和密码
        String adminName = request.getParameter("admin_name");
        String adminPass = request.getParameter("admin_pass");
        AdminInfo adminInfo=service.getByAdminNameAndPass(adminName, adminPass);
        if(adminInfo==null){
            request.setAttribute("tip_info", "用户名或者密码错误！");
            request.getRequestDispatcher("/admin_login.jsp").forward(request, response);
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("login_admin", adminInfo);
            request.getRequestDispatcher("/indextest.jsp").forward(request, response);
        }
    }

}
