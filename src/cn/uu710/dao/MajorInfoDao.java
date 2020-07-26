package cn.uu710.dao;

import cn.uu710.domain.MajorInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorInfoDao {

    /**
     * 获取记录总数
     * @return
     * @throws SQLException
     */
    public int getRecordCount() throws SQLException{
        String sql = "SELECT Count(*) as recordCount FROM major_info  ";
        // 获得数据库连接
        Connection conn = ConnUtil.getConn();
        // 生成预处理语句
        PreparedStatement pstat = conn.prepareStatement(sql);

        // 执行查询
        ResultSet rs = pstat.executeQuery();

        rs.next();
        return rs.getInt("recordCount");
    }

    /**
     * 分页查询
     * @param page 当前页
     * @param recordOfPage 每页显示条数
     * @return
     * @throws SQLException
     */
    public List<MajorInfo> search(int page, int recordOfPage) throws  SQLException{
        List<MajorInfo> majorInfoList = new ArrayList<MajorInfo>();
        String sql = " SELECT * FROM major_info where delete_flag=1 order by id limit ?,?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, (page-1)*recordOfPage);
        pstat.setInt(2, recordOfPage);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            MajorInfo majorInfo = new MajorInfo();
            majorInfo.setId(rs.getInt("id"));
            majorInfo.setMajorName(rs.getString("major_name"));
            majorInfo.setAcademyInfoId(rs.getInt("academy_info_id"));
            majorInfoList.add(majorInfo);
        }
        return majorInfoList;
    }

    public MajorInfo getById(Integer id) throws
            SQLException {
        String sql = "SELECT * FROM major_info where id=? ";
        // 获得数据库连接
        Connection conn = ConnUtil.getConn();
        // 生成预处理语句
        PreparedStatement pstat = conn.prepareStatement(sql);
        // 设置参数
        pstat.setInt(1, id);
        // 执行查询
        ResultSet rs = pstat.executeQuery();

        if (rs.next()) {
            // 封装对象
            MajorInfo majorInfo = new MajorInfo();
            majorInfo.setId(rs.getInt("id"));
            majorInfo.setMajorName(rs.getString("major_name"));
            majorInfo.setAcademyInfoId(rs.getInt("academy_info_id"));
            return majorInfo;
        }
        return null;
    }

    /**
     * 增加
     *
     * @param majorInfo
     * @return
     */
    public int add(MajorInfo majorInfo) throws Exception {
        String sql = "INSERT INTO major_info(major_name,academy_info_id,create_time,operate_time) VALUES(?,?,now(),now())";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1, majorInfo.getMajorName());
        pstat.setInt(2, majorInfo.getAcademyInfoId());
        return pstat.executeUpdate();
    }

    /**
     * 物理删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM major_info where id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        return pstat.executeUpdate();
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int logicDelete(int id) throws Exception {
        String sql = " UPDATE major_info SET delete_flag=0,operate_time=now() WHERE id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        return pstat.executeUpdate();
    }

    /**
     * 更新
     * @param majorInfo
     * @return
     * @throws SQLException
     */
    public int update(MajorInfo majorInfo) throws SQLException{
        String sql = " UPDATE major_info "
                + " SET major_name=?,academy_info_id=?,operate_time=now()  where id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1, majorInfo.getMajorName());
        pstat.setInt(2, majorInfo.getAcademyInfoId());
        pstat.setInt(3, majorInfo.getId());
        return pstat.executeUpdate();
    }

    public List<MajorInfo> findAll() throws SQLException {
        List<MajorInfo> majorInfoList = new ArrayList<MajorInfo>();
        String sql = " SELECT * FROM major_info where delete_flag=1 ";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);

        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            MajorInfo majorInfo = new MajorInfo();
            majorInfo.setId(rs.getInt("id"));
            majorInfo.setMajorName(rs.getString("major_name"));
            majorInfo.setAcademyInfoId(rs.getInt("academy_info_id"));
            majorInfoList.add(majorInfo);
        }
        return majorInfoList;
    }
}

