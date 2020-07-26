package cn.uu710.service;

import cn.uu710.dao.StudentAnswerDao;
import cn.uu710.domain.StudentAnswer;
import cn.uu710.util.ConnUtil;
import cn.uu710.vo.PageVO;

import java.sql.SQLException;
import java.util.List;


public class StudentAnswerService {
	private StudentAnswerDao studentAnswerDao=new StudentAnswerDao();
	
	public boolean existByStudentNum(int studentNum){
		try {
			return studentAnswerDao.existByStudentNum(studentNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	

	public boolean add(StudentAnswer studentAnswer) {
		try {
			boolean result = studentAnswerDao.add(studentAnswer);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();

		}
		return false;
	}

	public int getScore(Integer id) {
		try {
			return studentAnswerDao.getScore(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public PageVO<StudentAnswer> search(int page, int recordOfPage) {
		try {
			PageVO<StudentAnswer> pageVO = new PageVO<StudentAnswer>();

			int recordCount = this.studentAnswerDao.getRecordCount();

			int pageCount = ((recordCount - 1) / recordOfPage) + 1;
			if (page < 1) {
				page = 1;
			}
			if (page > pageCount) {
				page = pageCount;
			}

			List<StudentAnswer> studentAnswerList = this.studentAnswerDao
					.search(page, recordOfPage);

			pageVO.setPageCount(pageCount);
			pageVO.setRecordCount(recordCount);
			pageVO.setPage(page);
			pageVO.setRecordOfPage(recordOfPage);
			pageVO.setList(studentAnswerList);
			return pageVO;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnUtil.closeConn();
		}
	}

	public StudentAnswer getById(Integer id) throws ClassNotFoundException {
		try {
			StudentAnswer studentAnswer = studentAnswerDao.getById(id);
			return studentAnswer;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return null;
	}

	public List<StudentAnswer> findAll(int studentNum) {
		try {
			return studentAnswerDao.findAll(studentNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean exist(Integer studentNum) {
		try {
			return studentAnswerDao.exist(studentNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
