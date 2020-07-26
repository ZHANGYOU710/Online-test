package cn.uu710.service;

import cn.uu710.dao.StudentInfoDao;
import cn.uu710.domain.StudentInfo;
import cn.uu710.util.ConnUtil;
import cn.uu710.vo.PageVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public class StudentInfoService {
	private StudentInfoDao studentInfoDao = new StudentInfoDao();
	
	 public StudentInfo getStudentByStudentNumAndPass(Integer studentNum, String password){
		 try{
			 StudentInfo studentInfo= studentInfoDao.getStudentByStudentNum(studentNum);
			 if(null!=studentInfo && null!=studentInfo.getStudentPassWord() && studentInfo.getStudentPassWord().equals(password)){
				 return studentInfo;
			 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 ConnUtil.closeConn();
		 }
		 return null;
	 }
	 
	 public int updateByStudentNum(Integer studentNum, Integer classId,
				Integer totalScore){
		try {
			return studentInfoDao.updateByStudentNum(studentNum, classId, totalScore);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return -1;
	 }
	 
	 public Map<Integer, Integer> getPeopleByClass(){
		 try {
			return studentInfoDao.getPeopleByClass();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	 }





	public PageVO<StudentInfo> search(int page, int recordOfPage) {
		try {
			PageVO<StudentInfo> pageVO = new PageVO<>();

			int recordCount = this.studentInfoDao.getRecordCount();

			int pageCount = ((recordCount - 1) / recordOfPage) + 1;
			if (page < 1) {
				page = 1;
			}
			if (page > pageCount) {
				page = pageCount;
			}

			List<StudentInfo> studentInfoList = this.studentInfoDao.search(
					page, recordOfPage);

			pageVO.setPageCount(pageCount);
			pageVO.setRecordCount(recordCount);
			pageVO.setPage(page);
			pageVO.setRecordOfPage(recordOfPage);
			pageVO.setList(studentInfoList);
			return pageVO;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnUtil.closeConn();
		}
	}

//	public boolean updateClass(int classId, String recommendCourse,
//							   int totalScore, int studentId) {
//		try {
//			return studentInfoDao.updateClass(classId, recommendCourse,
//					totalScore, studentId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	public int getPeopleNumberByArea(int minScore, int maxScore) {
		try {
			return studentInfoDao.getPeopleNumberByArea(minScore, maxScore);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



	public Map<String, Double> getPingjunByArea() {
		try {
			return studentInfoDao.getPingjunByArea();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public StudentInfo getById(Integer id) {
		try {
			StudentInfo studentInfo = studentInfoDao.getById(id);
			return studentInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return null;
	}

	public boolean add(StudentInfo studentInfo) {
		try {
			boolean result = studentInfoDao.add(studentInfo);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();

		}
		return false;
	}

	public boolean delete(Integer id) {
		try {
			boolean result = studentInfoDao.delete(id);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();

		}
		return false;
	}

	public boolean update(StudentInfo studentInfo) {
		try {
			boolean result = studentInfoDao.update(studentInfo);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return false;
	}

	public boolean isExist(Integer studentNum, String studentPassWord) {
		try {
			StudentInfo studentInfo = studentInfoDao
					.getStudentByStudentNum(studentNum);
			if (null == studentInfo) {
				return false;
			}
			if (studentInfo.getStudentPassWord().equals(studentPassWord)) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return false;
	}

	public StudentInfo isLogin(Integer studentNum, String studentPass) {
		try {
			StudentInfo studentInfo = studentInfoDao
					.getStudentByStudentNum(studentNum);
			if (null == studentInfo) {
				return null;
			}
			if (studentInfo.getStudentPassWord().equals(studentPass)) {
				return studentInfo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return null;
	}

	public boolean updatePassword(Integer studentNum, String studentPass) {
		try {
			boolean result = studentInfoDao.updatePassword(studentNum,
					studentPass);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return false;
	}

	public StudentInfo getByStudentNum(Integer studentNum) {
		try {
			StudentInfo studentInfo = studentInfoDao
					.getStudentByStudentNum(studentNum);
			return studentInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.closeConn();
		}
		return null;
	}
}
