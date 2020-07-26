package cn.uu710.dao;

import cn.uu710.domain.PaperInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperInfoDao {
    /**
     * 分页查询
     *
     * @param page
     * @param recordOfpage
     * @return
     * @throws SQLException
     */
    public List<PaperInfo> search(int page, int recordOfpage)
            throws SQLException {
        List<PaperInfo> paperInfoList = new ArrayList<>();
        String sql = "SELECT * FROM paper_info ORDER BY question_num ASC "
                + " LIMIT ?,?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, (page - 1) * recordOfpage);
        pstat.setInt(2, recordOfpage);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setId(rs.getInt("id"));
            paperInfo.setQuestionNum(rs.getInt("question_num"));
            paperInfo.setQuestionContent(rs.getString("question_content"));
            paperInfo.setQuestionScore(rs.getInt("question_score"));
            paperInfo.setQuestionAnswer(rs.getString("question_answer"));

            paperInfo.setCreateTime(rs.getTimestamp("create_time"));
            paperInfo.setCreator(rs.getInt("creator"));
            paperInfo.setOperateTime(rs.getTimestamp("operate_time"));
            paperInfo.setOperator(rs.getInt("operator"));
            paperInfoList.add(paperInfo);

        }
        return paperInfoList;
    }

    /**
     * 获取记录总数
     *
     * @return
     * @throws SQLException
     */
    public int getRecordCount() throws SQLException {
        String sql = "select count(*) as recordCount from paper_info";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        ResultSet rs = pstat.executeQuery();
        rs.next();
        return rs.getInt("recordCount");
    }

    /**
     * 根据主键获取试卷信息
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public PaperInfo getById(Integer id) throws SQLException {

        String sql = "SELECT * FROM  paper_info where id=? ";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        ResultSet rs = pstat.executeQuery();

        if (rs.next()) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setId(rs.getInt("id"));
            paperInfo.setQuestionNum(rs.getInt("question_num"));
            paperInfo.setQuestionContent(rs.getString("question_content"));
            paperInfo.setQuestionScore(rs.getInt("question_score"));
            paperInfo.setQuestionAnswer(rs.getString("question_answer"));

            paperInfo.setCreateTime(rs.getDate("create_time"));
            paperInfo.setCreator(rs.getInt("creator"));
            paperInfo.setOperateTime(rs.getTimestamp("operate_time"));
            paperInfo.setOperator(rs.getInt("operator"));
            return paperInfo;
        }
        return null;
    }

    /**
     * 添加
     *
     * @param paperInfo
     * @return
     * @throws SQLException
     */
    public int add(PaperInfo paperInfo) throws SQLException {
        String sql = "INSERT INTO paper_info(question_num,question_content,question_score,question_answer,create_time) VALUES(?,?,?,?,now())";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, paperInfo.getQuestionNum());
        pstat.setString(2, paperInfo.getQuestionContent());
        pstat.setInt(3, paperInfo.getQuestionScore());
        pstat.setString(4, paperInfo.getQuestionAnswer());
        return pstat.executeUpdate();

    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM paper_info WHERE id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        return pstat.executeUpdate();
    }

    /**
     * 修改
     *
     * @param paperInfo
     * @return
     * @throws SQLException
     */
    public int update(PaperInfo paperInfo) throws SQLException {
        String sql = "UPDATE paper_info SET question_num=?,question_content=?,question_score=?,question_answer=?,operate_time=now()  where id=?";
        Connection conn = ConnUtil.getConn();

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setInt(1, paperInfo.getQuestionNum());
        pstat.setString(2, paperInfo.getQuestionContent());
        pstat.setInt(3, paperInfo.getQuestionScore());
        pstat.setString(4, paperInfo.getQuestionAnswer());

        pstat.setInt(5, paperInfo.getId());
        return pstat.executeUpdate();
    }

    public List<PaperInfo> findAll() throws SQLException {
        // 1.获取连接
        Connection conn = ConnUtil.getConn();
        // 2. sql
        String sql = "select * from paper_info order by question_num ";
        // 3 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);

        // 4 发送查询语句
        ResultSet rs = stmt.executeQuery();
        // 对结果集处理
        List<PaperInfo> list = new ArrayList<>();
        while (rs.next()) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setId(rs.getInt("id"));
            paperInfo.setQuestionNum(rs.getInt("question_num"));
            paperInfo.setQuestionContent(rs.getString("question_content"));
            paperInfo.setQuestionScore(rs.getInt("question_score"));
            paperInfo.setQuestionAnswer(rs.getString("question_answer"));
            list.add(paperInfo);
        }

        return list;

    }


    public PaperInfo getByQuestionNumId(Integer questionNumId)
            throws SQLException {

        String sql = "SELECT * FROM  paper_info where question_num=? ";

        Connection conn = ConnUtil.getConn();

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setInt(1, questionNumId);

        ResultSet rs = pstat.executeQuery();

        if (rs.next()) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setId(rs.getInt("id"));
            paperInfo.setQuestionNum(rs.getInt("question_num"));
            paperInfo.setQuestionContent(rs.getString("question_content"));
            paperInfo.setQuestionScore(rs.getInt("question_score"));
            paperInfo.setQuestionAnswer(rs.getString("question_answer"));
            paperInfo.setCreateTime(rs.getDate("create_time"));
            paperInfo.setCreator(rs.getInt("creator"));
            paperInfo.setOperateTime(rs.getTimestamp("operate_time"));
            paperInfo.setOperator(rs.getInt("operator"));
            return paperInfo;
        }
        return null;
    }
}
