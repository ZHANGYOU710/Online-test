package cn.uu710.dao;

import cn.uu710.domain.ClassInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 班级信息dao
 */
public class ClassInfoDao {
    /**
     * 获取所有班级信息
     *
     * @return
     * @throws SQLException
     */
    public List<ClassInfo> findAll() throws SQLException {
        List<ClassInfo> list = new ArrayList<>();
        // 1 获取连接
        Connection conn = ConnUtil.getConn();
        // 2 sql 语句
        String sql = " select * from class_info order by id ";
        // 3 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);

        // 执行查询
        ResultSet rs = stmt.executeQuery();
        //遍历结果集
        while (rs.next()) {
            ClassInfo classInfo = new ClassInfo();
            classInfo.setId(rs.getInt("id"));
            classInfo.setClassName(rs.getString("class_name"));
            classInfo.setMaxScore(rs.getInt("max_score"));
            classInfo.setMinScore(rs.getInt("min_score"));
            classInfo.setClassRule(rs.getString("class_rule"));

            list.add(classInfo);
        }

        return list;

    }

    public ClassInfo getById(Integer id) throws Exception {
        Connection conn = ConnUtil.getConn();
        String sql = "SELECT * FROM class_info where id=? ";
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        ResultSet rs = pstat.executeQuery();
        if (rs.next()) {
            ClassInfo classInfo = new ClassInfo();
            classInfo.setId(rs.getInt("id"));
            classInfo.setClassName(rs.getString("class_name"));
            classInfo.setMaxScore(rs.getInt("max_score"));
            classInfo.setMinScore(rs.getInt("min_score"));
            classInfo.setClassRule(rs.getString("class_rule"));
            return classInfo;
        }
        return null;
    }

    public boolean add(ClassInfo classInfo) throws Exception {
        String sql = "INSERT INTO class_info(class_name,max_score,min_score,create_time) VALUES(?,?,?,now())";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1, classInfo.getClassName());
        pstat.setInt(2, classInfo.getMaxScore());
        pstat.setInt(3, classInfo.getMinScore());

        int refectRows = pstat.executeUpdate();
        return refectRows > 0;
    }

    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM class_info WHERE id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        int resultRows = pstat.executeUpdate();
        return resultRows > 0;
    }

    public boolean update(ClassInfo classInfo) throws Exception {

        String sql = "UPDATE class_info SET class_name=?,max_score=?,min_score=?,operate_time=now()  where id=?";

        Connection conn = ConnUtil.getConn();

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setString(1, classInfo.getClassName());
        pstat.setInt(2, classInfo.getMaxScore());
        pstat.setInt(3, classInfo.getMinScore());
        pstat.setInt(4, classInfo.getId());
        int refectRows = pstat.executeUpdate();
        return refectRows > 0;
    }

}
