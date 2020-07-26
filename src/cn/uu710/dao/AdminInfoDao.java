package cn.uu710.dao;

import cn.uu710.domain.AdminInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员信息dao
 */
public class AdminInfoDao {
    /**
     * 根据管理员的用户名获取管理员信息
     *
     * @param adminName
     * @return
     * @throws SQLException
     */
    public AdminInfo getByAdminName(String adminName) throws SQLException {
        //获取数据库连接
        Connection conn = ConnUtil.getConn();
        // 定义sql语句
        String sql = "select * from admin_info where admin_name=?";
        // 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);
        //设置参数
        stmt.setString(1, adminName);
        // 发送sql
        ResultSet rs = stmt.executeQuery();

        //处理结果集
        if (rs.next()) {
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setId(rs.getInt("id"));
            adminInfo.setAdminName(rs.getString("admin_name"));
            adminInfo.setAdminPass(rs.getString("admin_pass"));
            adminInfo.setAdminPhone(rs.getString("admin_phone"));
            return adminInfo;
        }

        return null;
    }

    /**
     * 根据用户名更新用户密码
     *
     * @param adminName
     * @param adminPass
     * @return
     * @throws SQLException
     */
    public int updatePasswordByAdminName(String adminName, String adminPass) throws SQLException {
        // 1 获取连接
        Connection conn = ConnUtil.getConn();
        // 2 sql 语句
        String sql = "update admin_info set admin_pass=? where admin_name=? ";
        // 3 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 4 设置参数
        stmt.setString(1, adminPass);
        stmt.setString(2, adminName);

        // 5 发送sql
        return stmt.executeUpdate();

    }


    public boolean update(AdminInfo adminInfo) throws
            SQLException {

        String sql = "UPDATE admin_info SET admin_name=?,admin_phone=? where id=?";

        Connection conn = ConnUtil.getConn();

       PreparedStatement pstat = conn.prepareStatement(sql);
        // 璁剧疆鍙傛暟
        pstat.setString(1, adminInfo.getAdminName());
        pstat.setString(2, adminInfo.getAdminPhone());
        pstat.setInt(3, adminInfo.getId());
        int refectRows = pstat.executeUpdate();
        return refectRows > 0;
    }


}
