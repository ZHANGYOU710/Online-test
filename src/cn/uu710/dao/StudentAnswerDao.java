package cn.uu710.dao;

import cn.uu710.domain.PaperInfo;
import cn.uu710.domain.StudentAnswer;
import cn.uu710.domain.StudentInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentAnswerDao {
	private static final String TABLE_NAME = "student_answer";
	/**
	 * 根据学号判断该学生是否答过题 如果返回true 答过 返回false 没有答过
	 * 
	 * @param studentNum
	 * @return
	 * @throws SQLException
	 */
	public boolean existByStudentNum(int studentNum)
			throws  SQLException {
		Connection conn = ConnUtil.getConn();
		String sql = "SELECT COUNT(*) AS recordCount FROM student_answer WHERE student_num_id=? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, studentNum);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		return rs.getInt("recordCount") > 0;

	}

	public boolean add(StudentAnswer studentAnswer) throws SQLException{
		String sql = "INSERT INTO student_answer(student_num_id,question_num_id,answer_type,student_score,create_time) VALUES(?,?,?,?,now())";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, studentAnswer.getStudentNumId());
		pstat.setInt(2, studentAnswer.getQuestionNumId());
		pstat.setString(3, studentAnswer.getAnswerType());
		pstat.setInt(4, studentAnswer.getStudentScore());
		int refectRows = pstat.executeUpdate();
		return refectRows > 0;
	}

	public List<StudentAnswer> search(int page, int recordOfpage)
			throws SQLException{
		List<StudentAnswer> studentAnswerList = new ArrayList<StudentAnswer>();
		String sql = " SELECT  s.*,m.major_name,a.academy_name "
				+ " FROM student_answer a inner join student_info s on a.student_num_id=s.student_num "
				+ " inner join paper_info p on m.academy_info_id=a.id "
				+ " ORDER BY s.student_num ASC " + " LIMIT ?,?";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, (page - 1) * recordOfpage);
		pstat.setInt(2, recordOfpage);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			StudentAnswer studentAnswer = new StudentAnswer();
			studentAnswer.setId(rs.getInt("id"));
			studentAnswer.setAnswerType(rs.getString("answer_type"));
			studentAnswer.setCreateTime(rs.getTimestamp("create_time"));
			studentAnswer.setCreator(rs.getInt("creator"));
			studentAnswer.setOperateTime(rs.getTimestamp("operate_time"));
			studentAnswer.setOperator(rs.getInt("operator"));

			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudentNum(rs.getInt("student_num"));
			studentAnswer.setStudentInfo(studentInfo);

			PaperInfo paperInfo = new PaperInfo();
			paperInfo.setQuestionNum(rs.getInt("question_num"));
			studentAnswer.setPaperInfo(paperInfo);

			studentAnswerList.add(studentAnswer);
		}
		return studentAnswerList;
	}

	public int getRecordCount() throws SQLException {
		String sql = "select count(*) as recordCount from student_answer";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		rs.next();
		return rs.getInt("recordCount");
	}

	public int getScore(Integer id) throws  SQLException {
		String sql = "select sum(student_score) as sumscore from student_answer where student_num_id=?";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			return rs.getInt("sumscore");
		}
		return 0;
	}

	public StudentAnswer getById(Integer id) throws SQLException{
		String sql = "SELECT  s.*,m.major_name  FROM student_answer a inner join major_info m on s.major_info_id=m.id where s.id=? ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();

		if (rs.next()) {
			StudentAnswer studentAnswer = new StudentAnswer();
			studentAnswer.setId(rs.getInt("id"));
			studentAnswer.setAnswerType(rs.getString("answer_type"));
			studentAnswer.setCreateTime(rs.getTimestamp("create_time"));
			studentAnswer.setCreator(rs.getInt("creator"));
			studentAnswer.setOperateTime(rs.getTimestamp("operate_time"));
			studentAnswer.setOperator(rs.getInt("operator"));

			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudentNum(rs.getInt("student_num"));
			studentAnswer.setStudentInfo(studentInfo);

			PaperInfo paperInfo = new PaperInfo();
			paperInfo.setQuestionNum(rs.getInt("question_num"));
			studentAnswer.setPaperInfo(paperInfo);

			return studentAnswer;
		}
		return null;
	}

	public List<StudentAnswer> findAll(int studentNum) throws Exception {
		List<StudentAnswer> studentAnswerList = new ArrayList<StudentAnswer>();

		String sql = " SELECT * FROM ".concat(TABLE_NAME)
				+ " WHERE student_num_id=? ORDER BY question_num_id ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, studentNum);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			StudentAnswer studentAnswer = new StudentAnswer();
			studentAnswer.setId(rs.getInt("id"));
			studentAnswer.setAnswerType(rs.getString("answer_type"));
			studentAnswer.setQuestionNumId(rs.getInt("question_num_id"));
			studentAnswer.setCreateTime(rs.getTimestamp("create_time"));
			studentAnswer.setStudentScore(rs.getInt("student_score"));
			studentAnswer.setCreator(rs.getInt("creator"));
			studentAnswer.setOperateTime(rs.getTimestamp("operate_time"));
			studentAnswer.setOperator(rs.getInt("operator"));

			// StudentInfo studentInfo=new StudentInfo();
			// studentInfo.setStudentNum(rs.getInt("student_num"));
			// studentAnswer.setStudentInfo(studentInfo);
			//
			// PaperInfo paperInfo=new PaperInfo();
			// paperInfo.setQuestionNum(rs.getInt("question_num"));
			// studentAnswer.setPaperInfo(paperInfo);

			studentAnswerList.add(studentAnswer);
		}
		return studentAnswerList;
	}

	public boolean exist(Integer studentNum) throws
			SQLException {
		String sql = " select count(*) as totalCount from student_answer where student_num_id=? ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, studentNum);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			return rs.getInt("totalCount") > 0;
		}
		return false;
	}

}
