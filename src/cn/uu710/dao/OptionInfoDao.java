package cn.uu710.dao;

import cn.uu710.domain.OptionInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class OptionInfoDao {
	
	public int add(OptionInfo optionInfo) throws SQLException{
		String sql = "INSERT INTO option_info(question_num_id,option_content,option_type,create_time) VALUES(?,?,?,now())";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, optionInfo.getQuestionNumId());
		pstat.setString(2, optionInfo.getOptionContent());
		pstat.setString(3, optionInfo.getOptionType());

		return pstat.executeUpdate();
	}

	public int update(OptionInfo optionInfo) throws Exception{

		String sql = "UPDATE option_info SET question_num_id=?,option_content=?,option_type=?,operate_time=now()  where id=?";

		Connection conn = ConnUtil.getConn();

		PreparedStatement pstat = conn.prepareStatement(sql);

		pstat.setInt(1, optionInfo.getQuestionNumId());
		pstat.setString(2, optionInfo.getOptionContent());
		pstat.setString(3, optionInfo.getOptionType());
		pstat.setInt(4, optionInfo.getId());
		return pstat.executeUpdate();
	}
	
	public OptionInfo getByNumIdAndType(Integer questionNumId, String optionType)
			throws  SQLException {

		String sql = "SELECT * FROM option_info where question_num_id=? and option_type=? ";

		Connection conn = ConnUtil.getConn();

		PreparedStatement pstat = conn.prepareStatement(sql);

		pstat.setInt(1, questionNumId);
		pstat.setString(2, optionType);

		ResultSet rs = pstat.executeQuery();

		if (rs.next()) {
			OptionInfo optionInfo = new OptionInfo();
			optionInfo.setId(rs.getInt("id"));
			optionInfo.setQuestionNumId(rs.getInt("question_num_id"));
			optionInfo.setOptionContent(rs.getString("option_content"));
			optionInfo.setOptionType(rs.getString("option_type"));
			return optionInfo;
		}
		return null;
	}
	
	/**
	 * 通过题目编号获取该题目的所有选项(ABCD)
	 * @param questionNum
	 * @return
	 * @throws SQLException
	 */
	public List<OptionInfo> getByQuestionNum(int questionNum) throws  SQLException{
		// 1 获取连接
		Connection conn = ConnUtil.getConn();
		// 2 sql 语句
		String sql = "select * from option_info where question_num_id=? order by option_type ";
		// 3 生成预处理语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionNum);

		// 执行操作
		ResultSet rs = stmt.executeQuery();
		List<OptionInfo> list=new ArrayList<>();
		while (rs.next()) {
			OptionInfo optionInfo = new OptionInfo();
			optionInfo.setId(rs.getInt("id"));
			optionInfo.setQuestionNumId(rs.getInt("question_num_id"));
			optionInfo.setOptionContent(rs.getString("option_content"));
			optionInfo.setOptionType(rs.getString("option_type"));
			list.add(optionInfo);
		
		}
		return list;
	}
}
