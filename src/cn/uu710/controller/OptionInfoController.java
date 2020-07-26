package cn.uu710.controller;

import cn.uu710.domain.OptionInfo;
import cn.uu710.service.OptionInfoService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/option/optioninfo.do")
public class OptionInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OptionInfoService optionInfoService = new OptionInfoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "update":
			update(request, response);
			break;
		case "enter_option_update":
			enterOptionUpdate(request, response);
			break;
		}
	}

	private void enterOptionUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取题号和选项
		String questionNumId=request.getParameter("question_num_id");
		String optionType=request.getParameter("option_type");
		
		OptionInfo optionInfo=optionInfoService.getByNumIdAndType(Integer.valueOf(questionNumId), optionType);
		if(null==optionInfo){
			optionInfo=new OptionInfo();
			optionInfo.setQuestionNumId(Integer.valueOf(questionNumId));
			optionInfo.setOptionType(optionType);
		}
		request.setAttribute("option_info", optionInfo);
		request.getRequestDispatcher("/admin/option/option_edit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数
		String strId=request.getParameter("id");
		String questionNumId = request.getParameter("question_num_id");
		String optionContent = request.getParameter("option_content");
		String optionType = request.getParameter("option_type");
		//封装对象
		OptionInfo optionInfo = new OptionInfo();
		optionInfo.setQuestionNumId(Integer.valueOf(questionNumId));
		optionInfo.setOptionContent(optionContent);
		optionInfo.setOptionType(optionType);
		//判断添加还是修改
		if(strId==null || strId.equals("")){
			int result = optionInfoService.add(optionInfo);
			if (result>0) {
				request.setAttribute("tip_info", "添加选项成功");
			} else {
				request.setAttribute("tip_info", "添加选项失败");
			}
		}else{
			Integer id = Integer.valueOf(request.getParameter("id"));
			optionInfo.setId(id);
			int result = optionInfoService.update(optionInfo);

			if (result>0) {
				request.setAttribute("tip_info", "修改选项成功");
			} else {
				request.setAttribute("tip_info", "修改选项失败");
			}
			
		}

		request.getRequestDispatcher("/result.jsp")
				.forward(request, response);
	}

	

}
