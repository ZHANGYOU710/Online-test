package cn.uu710.controller;

import cn.uu710.domain.AcademyInfo;
import cn.uu710.domain.MajorInfo;
import cn.uu710.domain.StudentInfo;
import cn.uu710.service.AcademyInfoService;
import cn.uu710.service.MajorInfoService;
import cn.uu710.service.StudentInfoService;
import cn.uu710.util.SessionUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/personalcenter/manage.do")
public class StudentCenterController extends HttpServlet {
    private StudentInfoService studentInfoService = new StudentInfoService();
    private MajorInfoService majorInfoService = new MajorInfoService();
    private AcademyInfoService academyInfoService = new AcademyInfoService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "enter_update":
                enterUpdate(request, response);
                break;

            case "update":
                update(request, response);
                break;
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo loginStudent = SessionUtil.getStudentInfoFromSession(request);
        String studentNum = request.getParameter("student_num");
        String studentName = request.getParameter("student_name");
        String studentGender = request.getParameter("student_gender");
        String studentPhone = request.getParameter("student_phone");
        String studentProvince = request.getParameter("student_province");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(loginStudent.getId());
        studentInfo.setStudentNum(Integer.valueOf(studentNum));
        studentInfo.setStudentName(studentName);

        studentInfo.setStudentGender(Integer.valueOf(studentGender));
        studentInfo.setStudentPhone(studentPhone);
        studentInfo.setStudentProvince(studentProvince);
        studentInfo.setStudentPassWord(loginStudent.getStudentPassWord());
        studentInfo.setMajorInfoId(loginStudent.getMajorInfoId());
        studentInfo.setOperator(loginStudent.getId());
        boolean result = studentInfoService.update(studentInfo);

        if (result) {
            request.setAttribute("tip_info", "修改信息成功");
        } else {
            request.setAttribute("tip_info", "修改信息失败");
        }

        request.getRequestDispatcher("manage.do?action=detail")
                .forward(request, response);

    }

    private void enterUpdate(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        StudentInfo studentInfo = SessionUtil.getStudentInfoFromSession(request);
        StudentInfo studentInfo1 = studentInfoService
                .getByStudentNum(studentInfo.getStudentNum());
        MajorInfo majorInfo = majorInfoService.getById(studentInfo1.getMajorInfoId());
        AcademyInfo academyInfo = academyInfoService.getById(majorInfo.getAcademyInfoId());
        request.setAttribute("student_info", studentInfo1);
        request.setAttribute("majorInfo", majorInfo);
        request.setAttribute("academyInfo", academyInfo);
        request.getRequestDispatcher("/student/personalcenter/student_edit.jsp").forward(request,
                response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentInfo studentInfo = SessionUtil.getStudentInfoFromSession(request);
        StudentInfo studentInfo1 = studentInfoService
                .getByStudentNum(studentInfo.getStudentNum());

        MajorInfo majorInfo = majorInfoService.getById(studentInfo1.getMajorInfoId());
        AcademyInfo academyInfo = academyInfoService.getById(majorInfo.getAcademyInfoId());
        request.setAttribute("student_info", studentInfo1);
        request.setAttribute("majorInfo", majorInfo);
        request.setAttribute("academyInfo", academyInfo);
        request.getRequestDispatcher("/student/personalcenter/student_detail.jsp").forward(request,
                response);
    }

    private void modifyPassword(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        String originalPass = request.getParameter("original_pass");
        String newPass = request.getParameter("new_pass");
        StudentInfo studentInfo = SessionUtil.getStudentInfoFromSession(request);
        try {
            if (!originalPass.equals(studentInfo.getStudentPassWord())) {
                request.setAttribute("tip_info", "原密码不正确");
                request.getRequestDispatcher("/student/personalcenter/modify_password.jsp").forward(
                        request, response);
            } else {
                boolean result = studentInfoService.updatePassword(
                        studentInfo.getStudentNum(), newPass);
                if (result) {
                    request.setAttribute("tip_info", "密码修改成功");
                } else {
                    request.setAttribute("tip_info", "密码修改失败");
                }
                request.getRequestDispatcher("/student/personalcenter/modify_password.jsp").forward(
                        request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void enterModifyPassword(HttpServletRequest request,
                                     HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/student/personalcenter/modify_password.jsp").forward(request,
                response);
    }

}
