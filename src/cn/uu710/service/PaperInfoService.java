package cn.uu710.service;

import cn.uu710.dao.OptionInfoDao;
import cn.uu710.dao.PaperInfoDao;
import cn.uu710.domain.OptionInfo;
import cn.uu710.domain.PaperInfo;
import cn.uu710.util.ConnUtil;
import cn.uu710.vo.PageVO;

import java.sql.SQLException;
import java.util.List;



public class PaperInfoService {

	private PaperInfoDao dao = new PaperInfoDao();
	private OptionInfoDao optionInfoDao=new OptionInfoDao();

	public PageVO<PaperInfo> search(int page, int recordOfPage) {
		try {
			PageVO<PaperInfo> pageVO = new PageVO<PaperInfo>();

			int recordCount = dao.getRecordCount();

			int pageCount = ((recordCount - 1) / recordOfPage) + 1;
			if (page < 1) {
				page = 1;
			}
			if (page > pageCount) {
				page = pageCount;
			}

			List<PaperInfo> paperInfoList = dao.search(page,
					recordOfPage);
			pageVO.setPageCount(pageCount);
			pageVO.setRecordCount(recordCount);
			pageVO.setPage(page);
			pageVO.setRecordOfPage(recordOfPage);
			pageVO.setList(paperInfoList);
			return pageVO;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnUtil.closeConn();
		}
	}

	public PaperInfo getById(Integer id)  {
		try {
			PaperInfo paperInfo = dao.getById(id);
			return paperInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return null;
	}

	public int add(PaperInfo paperInfo)  {
		try {
			return dao.add(paperInfo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();

		}
		return -1;
	}

	public int delete(Integer id) {
		try {
			return dao.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();

		}
		return -1;
	}

	public int update(PaperInfo paperInfo){
		try {
			return  dao.update(paperInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return -1;
	}

	public List<PaperInfo> findAll() {
		try {
			List<PaperInfo> paperList=dao.findAll();
			for(PaperInfo paperInfo:paperList){
				//根据题号获取每道题的四个选项
				List<OptionInfo> optionList=optionInfoDao.getByQuestionNum(paperInfo.getQuestionNum());
				paperInfo.setOptionList(optionList);
			}
			return paperList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PaperInfo getByQuestionNumId(Integer questionNumId) {
		try {
			return dao.getByQuestionNumId(questionNumId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
