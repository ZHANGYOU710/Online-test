package cn.uu710.controller;

import cn.uu710.constant.Constants;
import cn.uu710.domain.AcademyInfo;
import cn.uu710.domain.MajorInfo;
import cn.uu710.service.AcademyInfoService;
import cn.uu710.service.MajorInfoService;
import cn.uu710.vo.PageVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/major/majorinfo.do")
public class MajorInfoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MajorInfoService service=new MajorInfoService();
    private AcademyInfoService academyInfoService=new AcademyInfoService();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "search":
                search(request,response);
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

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;

        String strPage=request.getParameter("page");
        if(strPage!=null && !strPage.equals("")){
            page=Integer.parseInt(strPage);
        }
        PageVO<MajorInfo> pageVo=service.search(page, Constants.RECORD_OF_PAGE);
        request.setAttribute("page_vo", pageVo);
        request.getRequestDispatcher("/admin/major/major_list.jsp").forward(request, response);

    }

    private void updateSave(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        // 获取参数值
        String majorName=request.getParameter("major_name");
        String academyInfoId=request.getParameter("academy_id");
        String strId=request.getParameter("id");
        //封装对象
        MajorInfo majorInfo=new MajorInfo();
        majorInfo.setMajorName(majorName);
        majorInfo.setAcademyInfoId(Integer.parseInt(academyInfoId));
        majorInfo.setId(Integer.parseInt(strId));
        int result = service.update(majorInfo);
        if (result > 0) {
            request.setAttribute("tip_info", "修改专业成功！");
        } else {
            request.setAttribute("tip_info", "修改专业失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    private void enterUpdate(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        // 获取id
        String strId = request.getParameter("id");
        // 通过id获取完整学院信息
        MajorInfo majorInfo = service.getById(Integer.parseInt(strId));
        // 设置属性
        request.setAttribute("major_info", majorInfo);
        //获取所有学院信息
        List<AcademyInfo> academyList=academyInfoService.findAll();
        request.setAttribute("academy_list", academyList);
        // 请求转发
        request.getRequestDispatcher("/admin/major/major_edit.jsp")
                .forward(request, response);
    }

    private void addSave(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // 获取参数值
        String majorName=request.getParameter("major_name");
        String academyInfoId=request.getParameter("academy_id");
        //封装对象
        MajorInfo majorInfo=new MajorInfo();
        majorInfo.setMajorName(majorName);
        majorInfo.setAcademyInfoId(Integer.parseInt(academyInfoId));
        int result = service.add(majorInfo);
        if (result > 0) {
            request.setAttribute("tip_info", "添加专业成功！");
        } else {
            request.setAttribute("tip_info", "添加专业失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void enterAdd(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //获取所有学院信息
        List<AcademyInfo> academyList=academyInfoService.findAll();
        request.setAttribute("academy_list", academyList);
        //请求转发
        request.getRequestDispatcher("/admin/major/major_add.jsp").forward(
                request, response);
    }

    private void deleteById(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        int result = service.delete(Integer.parseInt(strId));
        if (result > 0) {
            request.setAttribute("tip_info", "删除专业成功！");
        } else {
            request.setAttribute("tip_info", "删除专业失败！");
        }
        request.getRequestDispatcher("majorinfo.do?action=search").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
