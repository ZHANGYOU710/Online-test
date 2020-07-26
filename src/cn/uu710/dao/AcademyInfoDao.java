package cn.uu710.dao;

import cn.uu710.domain.AcademyInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学院信息dao
 */
public class AcademyInfoDao {
    /**
     * 查询所有学院信息
     *
     * @return
     * @throws SQLException
     */
    public List<AcademyInfo> findAll() throws SQLException {
        Connection conn = ConnUtil.getConn();
        String sql = "select * from academy_info";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<AcademyInfo> academyInfoList = new ArrayList<>();
        while (rs.next()) {
            AcademyInfo academyInfo = new AcademyInfo();
            academyInfo.setId(rs.getInt("id"));
            academyInfo.setAcademyName(rs.getString("academy_name"));
            //..... 其他字段学员补充
            academyInfoList.add(academyInfo);
        }
        return academyInfoList;
    }

    /**
     * 根据主键删除学院信息
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int deleteById(Integer id) throws SQLException {
        Connection conn = ConnUtil.getConn();
        String sql = "delete from academy_info where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    /**
     * 添加学院信息
     *
     * @param academyInfo
     * @return int
     * @throws SQLException
     */
    public int add(AcademyInfo academyInfo) throws SQLException {
        Connection conn = ConnUtil.getConn();
        String sql = "insert into academy_info(academy_name,create_time,operate_time) values(?,now(),now())";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, academyInfo.getAcademyName());
        return stmt.executeUpdate();
    }

    /**
     * 修改学院信息
     *
     * @param academyInfo
     * @return
     * @throws SQLException
     */
    public int update(AcademyInfo academyInfo) throws SQLException {
        Connection conn = ConnUtil.getConn();
        String sql = "update academy_info set academy_name=?,operate_time=now() where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, academyInfo.getAcademyName());
        stmt.setInt(2, academyInfo.getId());
        return stmt.executeUpdate();
    }

    /**
     * 通过主键获取学院信息
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public AcademyInfo getById(int id) throws SQLException {
        Connection conn = ConnUtil.getConn();
        String sql = "select * from academy_info where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            AcademyInfo academyInfo = new AcademyInfo();
            academyInfo.setId(rs.getInt("id"));
            academyInfo.setAcademyName(rs.getString("academy_name"));
            //.....
            return academyInfo;
        }
        return null;
    }

}
