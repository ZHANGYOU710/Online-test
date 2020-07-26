package cn.uu710.controller;

import cn.uu710.domain.AcademyInfo;
import cn.uu710.service.AcademyInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 学院信息
 */
@WebServlet("/admin/academy/academyinfo.do")
public class AcademyInfoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AcademyInfoService service = new AcademyInfoService();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "findAll":
                findAll(request, response);
                break;
            case "delete":
                deleteById(request, response);
                break;
            case "enter_add":
                enterAdd(request, response);
                break;
            case "add":
                addSave(request, response);
                break;
            case "enter_update":
                enterUpdate(request, response);
                break;
            case "update":
                updateSave(request, response);
        }
    }

    private void updateSave(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        // 获取参数值
        String academyName = request.getParameter("academy_name");
        String strId=request.getParameter("id");
        AcademyInfo academyInfo = new AcademyInfo();
        academyInfo.setAcademyName(academyName);
        academyInfo.setId(Integer.parseInt(strId));
        int result = service.update(academyInfo);
        if (result > 0) {
            request.setAttribute("tip_info", "修改学院成功！");
        } else {
            request.setAttribute("tip_info", "修改学院失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    private void enterUpdate(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        // 获取id
        String strId = request.getParameter("id");
        // 通过id获取完整学院信息
        AcademyInfo academyInfo = service.getById(Integer.parseInt(strId));
        // 设置属性
        request.setAttribute("academy_info", academyInfo);
        // 请求转发
        request.getRequestDispatcher("/admin/academy/academy_edit.jsp")
                .forward(request, response);
    }

    private void addSave(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // 获取参数值
        String academyName = request.getParameter("academy_name");
        AcademyInfo academyInfo = new AcademyInfo();
        academyInfo.setAcademyName(academyName);
        int result = service.add(academyInfo);
        if (result > 0) {
            request.setAttribute("tip_info", "添加学院成功！");
        } else {
            request.setAttribute("tip_info", "添加学院失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void enterAdd(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/academy/academy_add.jsp").forward(
                request, response);
    }

    private void deleteById(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        int result = service.deleteById(Integer.parseInt(strId));
        if (result > 0) {
            request.setAttribute("tip_info", "删除学院成功！");
        } else {
            request.setAttribute("tip_info", "删除学院失败！");
        }
        request.getRequestDispatcher("academyinfo.do?action=findAll").forward(
                request, response);
    }

    private void findAll(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        List<AcademyInfo> list = service.findAll();
        request.setAttribute("academy_list", list);
        request.getRequestDispatcher("/admin/academy/academy_list.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }



}
