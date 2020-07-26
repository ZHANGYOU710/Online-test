package cn.uu710.controller;

import cn.uu710.domain.PaperInfo;
import cn.uu710.service.PaperInfoService;
import cn.uu710.vo.PageVO;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/paper/paperinfo.do")
public class PaperInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaperInfoService paperInfoService = new PaperInfoService();

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
		case "detail":
			detail(request,response);
			break;
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		PaperInfo paperInfo=paperInfoService.getById(Integer.parseInt(strId));
		request.setAttribute("paper_info", paperInfo);
		request.getRequestDispatcher("/admin/paper/paper_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=1;
		String strPage=request.getParameter("page");
		if(strPage!=null && !strPage.equals("")){
			 page = Integer.valueOf(strPage);
		}
		
		int recordOfPage = 5;
		PageVO<PaperInfo> pageVO = paperInfoService.search(page, recordOfPage);
		request.setAttribute("page_vo", pageVO);
		request.getRequestDispatcher("/admin/paper/paper_list.jsp").forward(
				request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionNum = request.getParameter("question_num");
		String questionContent = request.getParameter("question_content");
		String questionScore = request.getParameter("question_score");
		String questionAnswer = request.getParameter("question_answer");
		PaperInfo paperInfo = new PaperInfo();
		paperInfo.setQuestionNum(Integer.valueOf(questionNum));
		paperInfo.setQuestionContent(questionContent);
		paperInfo.setQuestionScore(Integer.valueOf(questionScore));
		paperInfo.setQuestionAnswer(questionAnswer);
		paperInfo.setCreateTime(new Date());
		// AdminInfo adminInfo=SessionUtil.getAdminInfoFromSession(request);
		// paperInfo.setCreator(adminInfo.getId());
		// paperInfo.setOperator(adminInfo.getId());
		int result = paperInfoService.add(paperInfo);
		if (result > 0) {
			request.setAttribute("tip_info", "添加试题成功");
		} else {
			request.setAttribute("tip_info", "添加试题失败");
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	private void enterAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/paper/paper_add.jsp").forward(
				request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		int result = paperInfoService.delete(id);
		if (result > 0) {
			request.setAttribute("tip_info", "删除试题成功");
		} else {
			request.setAttribute("tip_info", "删除试题失败");
		}
		request.getRequestDispatcher("paperinfo.do?action=search&page=1")
				.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String questionNum = request.getParameter("question_num");
		String questionContent = request.getParameter("question_content");
		String questionScore = request.getParameter("question_score");
		String questionAnswer = request.getParameter("question_answer");
		PaperInfo paperInfo = new PaperInfo();
		paperInfo.setId(id);
		paperInfo.setQuestionNum(Integer.valueOf(questionNum));
		paperInfo.setQuestionContent(questionContent);
		paperInfo.setQuestionScore(Integer.valueOf(questionScore));
		paperInfo.setQuestionAnswer(questionAnswer);
		// AdminInfo adminInfo=SessionUtil.getAdminInfoFromSession(request);
		// paperInfo.setOperator(adminInfo.getId());
		int result = paperInfoService.update(paperInfo);

		if (result > 0) {
			request.setAttribute("tip_info", "修改试题成功");
		} else {
			request.setAttribute("tip_info", "修改试题失败");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	private void enterUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		PaperInfo paperInfo = paperInfoService.getById(id);
		request.setAttribute("paper_info", paperInfo);
		request.getRequestDispatcher("/admin/paper/paper_edit.jsp").forward(
				request, response);
	}

}
