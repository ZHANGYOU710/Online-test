package cn.uu710.controller;

import cn.uu710.domain.ClassInfo;
import cn.uu710.domain.PaperInfo;
import cn.uu710.domain.StudentAnswer;
import cn.uu710.domain.StudentInfo;
import cn.uu710.service.ClassInfoService;
import cn.uu710.service.PaperInfoService;
import cn.uu710.service.StudentAnswerService;
import cn.uu710.service.StudentInfoService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/student/answer.do")
public class StudentAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentAnswerService service=new StudentAnswerService();
    private PaperInfoService paperInfoService=new PaperInfoService();
    private ClassInfoService classInfoService=new ClassInfoService();
    private StudentInfoService studentInfoService=new StudentInfoService();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1设置编码集
		request.setCharacterEncoding("utf-8");
		//2获取学号
		StudentInfo studentInfo=(StudentInfo) request.getSession().getAttribute("login_student");
		int studentNum=studentInfo.getStudentNum();
		//3获取学生答题信息
		Map<String,String[]> map=request.getParameterMap();
		//总分
		int totalScore=0;
		for(Map.Entry entry:map.entrySet()){
			String key=(String) entry.getKey();
			String[] value=(String[]) entry.getValue();
			String answerNum=key.substring(key.lastIndexOf("_")+1,key.length());
			System.out.println("key:"+key+"| value:"+value[0] +"| answernum:"+answerNum);
			//4排除提交按钮
			if(key.startsWith("answer_")){
				//5封装对象
				StudentAnswer studentAnswer=new StudentAnswer();
				studentAnswer.setStudentNumId(studentNum);
				studentAnswer.setQuestionNumId(Integer.parseInt(answerNum));
				studentAnswer.setAnswerType(value[0]);
				PaperInfo paperInfo=paperInfoService.getByQuestionNumId(Integer.parseInt(answerNum));
				studentAnswer.setStudentScore(0);
				//答对题
				if(paperInfo.getQuestionAnswer().equals(value[0])){
					studentAnswer.setStudentScore(paperInfo.getQuestionScore());
					totalScore+=paperInfo.getQuestionScore();
				}
				//6保存信息
				service.add(studentAnswer);
			}
		}
		
		int classId=0;
		//获取所有分班的班级
		List<ClassInfo> classList=classInfoService.findAll();
		//遍历班级信息，获取应分配班级的id
		for(ClassInfo classInfo:classList){
			if(totalScore>=classInfo.getMinScore() && totalScore<=classInfo.getMaxScore()){
				classId=classInfo.getId();
			}
		}
		//更新该学生的总分和被分配到的班级
		studentInfoService.updateByStudentNum(studentNum, classId, totalScore);
		
		request.setAttribute("tip_info", "您答题完毕！");
		request.getRequestDispatcher("/student/index.jsp").forward(request, response);
		
		
	}

}
