package cn.uu710.dao;

import cn.uu710.domain.AcademyInfo;
import cn.uu710.domain.MajorInfo;
import cn.uu710.domain.StudentInfo;
import cn.uu710.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentInfoDao {
    /**
     * 根据学号获取学生信息
     *
     * @param studentNum
     * @return
     * @throws SQLException
     */
    public StudentInfo getStudentByStudentNum(Integer studentNum) throws SQLException {
        //1 获取连接
        Connection conn = ConnUtil.getConn();
        //2 sql
        String sql = "select * from student_info where student_num=? ";
        // 3 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, studentNum);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            //封装成对象
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(rs.getInt("id"));
            studentInfo.setStudentNum(rs.getInt("student_num"));
            studentInfo.setStudentPassWord(rs.getString("student_password"));
            studentInfo.setStudentName(rs.getString("student_name"));
            studentInfo.setStudentGender(rs.getInt("student_gender"));
            studentInfo.setStudentPhone(rs.getString("student_phone"));
            studentInfo.setStudentProvince(rs.getString("student_province"));
            studentInfo.setStudentPassWord(rs.getString("student_password"));
            studentInfo.setMajorInfoId(rs.getInt("major_info_id"));
            // 其余的学员自行添加

            return studentInfo;
        }
        return null;
    }

    /**
     * 根据该学生的学号更新被分配到的班级和答题所得总分
     *
     * @param studentNum
     * @param classId
     * @param totalScore
     * @return
     * @throws SQLException
     */
    public int updateByStudentNum(Integer studentNum, Integer classId,
                                  Integer totalScore) throws SQLException {

        // 1 获取连接
        Connection conn = ConnUtil.getConn();
        // 2 sql
        String sql = "update student_info set class_id=?,total_score=?,operate_time=now() where student_num=? ";
        // 3 生成预处理语句
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, classId);
        stmt.setInt(2, totalScore);
        stmt.setInt(3, studentNum);

        return stmt.executeUpdate();
    }

    /**
     * 按班级id进行分组
     *
     * @return
     * @throws SQLException
     */
    public Map<Integer, Integer> getPeopleByClass()
            throws SQLException {
        Connection conn = ConnUtil.getConn();

        String sql = "select  class_id,count(*) as peopleNum from student_info where class_id is not null group by class_id ";

        PreparedStatement stat = conn.prepareStatement(sql);
        Map<Integer, Integer> map = new HashMap<>();
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            map.put(rs.getInt("class_id"), rs.getInt("peopleNum"));
        }
        return map;
    }

    /**
     * 分页查询
     *
     * @param page
     * @param recordOfpage
     * @return
     * @throws ClassNotFoundException
     */
    public List<StudentInfo> search(int page, int recordOfpage)
            throws SQLException {
        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        String sql = " SELECT  s.*,m.major_name,a.academy_name "
                + " FROM student_info s inner join major_info m on s.major_info_id=m.id "
                + " inner join academy_info a on m.academy_info_id=a.id "
                + " ORDER BY s.student_num ASC " + " LIMIT ?,?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, (page - 1) * recordOfpage);
        pstat.setInt(2, recordOfpage);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(rs.getInt("id"));
            studentInfo.setStudentNum(rs.getInt("student_num"));
            studentInfo.setStudentName(rs.getString("student_name"));
            studentInfo.setStudentPassWord(rs.getString("student_password"));
            studentInfo.setStudentGender(rs.getInt("student_gender"));
            studentInfo.setStudentPhone(rs.getString("student_phone"));
            studentInfo.setStudentProvince(rs.getString("student_province"));
            studentInfo.setCreateTime(rs.getTimestamp("create_time"));
            studentInfo.setCreator(rs.getInt("creator"));
            studentInfo.setOperateTime(rs.getTimestamp("operate_time"));
            studentInfo.setOperator(rs.getInt("operator"));
            studentInfo.setRecommendCourse(rs.getString("recommend_course"));
            MajorInfo majorInfo = new MajorInfo();
            majorInfo.setMajorName(rs.getString("major_name"));
            studentInfo.setMajorInfo(majorInfo);

            AcademyInfo academyInfo = new AcademyInfo();
            academyInfo.setAcademyName(rs.getString("academy_name"));
            studentInfo.setAcademyInfo(academyInfo);

            studentInfoList.add(studentInfo);
        }
        return studentInfoList;
    }

    /**
     * 根据区域人数进行分组
     *
     * @param minScore
     * @param maxScore
     * @return
     * @throws SQLException
     */
    public int getPeopleNumberByArea(int minScore, int maxScore)
            throws  SQLException {
        String sql = "select count(*) as peopelNumber from student_info where total_score>=? and total_score<=? ";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, minScore);
        pstat.setInt(2, maxScore);
        ResultSet rs = pstat.executeQuery();
        rs.next();
        return rs.getInt("peopelNumber");
    }

    /**
     * 根据区域平均分进行分组
     *
     * @return
     * @throws SQLException
     */
    public Map<String, Double> getPingjunByArea()
            throws SQLException {
        String sql = "select student_province, avg(total_score) as avgScore from student_info group by student_province ";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        Map<String, Double> map = new HashMap<>();
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            map.put(rs.getString("student_province"), rs.getDouble("avgScore"));
        }
        return map;
    }


    /**
     * 获取记录总数
     *
     * @return
     * @throws SQLException
     */
    public int getRecordCount() throws SQLException {
        String sql = "select count(*) as recordCount from student_info";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        ResultSet rs = pstat.executeQuery();
        rs.next();
        return rs.getInt("recordCount");
    }

    /**
     * 根据主键获取学生信息
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public StudentInfo getById(Integer id) throws SQLException {

        String sql = "SELECT  s.*,m.major_name  FROM student_info s inner join major_info m on s.major_info_id=m.id where s.id=? ";

        Connection conn = ConnUtil.getConn();

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setInt(1, id);

        ResultSet rs = pstat.executeQuery();

        if (rs.next()) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(rs.getInt("id"));
            studentInfo.setStudentNum(rs.getInt("student_num"));
            studentInfo.setStudentName(rs.getString("student_name"));
            studentInfo.setStudentPassWord(rs.getString("student_password"));
            studentInfo.setStudentGender(rs.getInt("student_gender"));
            studentInfo.setStudentPhone(rs.getString("student_phone"));
            studentInfo.setStudentProvince(rs.getString("student_province"));
            studentInfo.setMajorInfoId(rs.getInt("major_info_id"));
            studentInfo.setCreateTime(rs.getTimestamp("create_time"));
            studentInfo.setCreator(rs.getInt("creator"));
            studentInfo.setOperateTime(rs.getTimestamp("operate_time"));
            studentInfo.setOperator(rs.getInt("operator"));
            studentInfo.setClassId(rs.getInt("class_id"));
            studentInfo.setRecommendCourse(rs.getString("recommend_course"));
            MajorInfo majorInfo = new MajorInfo();
            majorInfo.setMajorName(rs.getString("major_name"));
            studentInfo.setMajorInfo(majorInfo);

            return studentInfo;
        }
        return null;
    }


    /**
     * 添加学生信息
     *
     * @param studentInfo
     * @return
     * @throws Exception
     */
    public boolean add(StudentInfo studentInfo) throws Exception {
        String sql = "INSERT INTO student_info(student_num,student_name,student_password,student_gender,major_info_id,student_phone,student_province,create_time) VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, studentInfo.getStudentNum());
        pstat.setString(2, studentInfo.getStudentName());
        pstat.setString(3, studentInfo.getStudentPassWord());
        pstat.setInt(4, studentInfo.getStudentGender());
        pstat.setInt(5, studentInfo.getMajorInfoId());
        pstat.setString(6, studentInfo.getStudentPhone());
        pstat.setString(7, studentInfo.getStudentProvince());
        pstat.setDate(8, new java.sql.Date(studentInfo.getCreateTime()
                .getTime()));

        int refectRows = pstat.executeUpdate();
        return refectRows > 0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM student_info where id=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        int resultRows = pstat.executeUpdate();
        return resultRows > 0;
    }

    /**
     * 修改
     *
     * @param studentInfo
     * @return
     * @throws Exception
     */
    public boolean update(StudentInfo studentInfo) throws Exception {

        String sql = "UPDATE student_info SET student_num=?,student_name=?,student_gender=?,major_info_id=?,student_phone=?,student_province=?,operate_time=now()  where id=?";

        Connection conn = ConnUtil.getConn();

        PreparedStatement pstat = conn.prepareStatement(sql);

        pstat.setInt(1, studentInfo.getStudentNum());
        pstat.setString(2, studentInfo.getStudentName());
        pstat.setInt(3, studentInfo.getStudentGender());
        pstat.setInt(4, studentInfo.getMajorInfoId());
        pstat.setString(5, studentInfo.getStudentPhone());
        pstat.setString(6, studentInfo.getStudentProvince());
        pstat.setInt(7, studentInfo.getId());
        int refectRows = pstat.executeUpdate();
        return refectRows > 0;
    }


    /**
     * 学生更新密码
     *
     * @param studentNum
     * @param studentPass
     * @return
     * @throws Exception
     */
    public boolean updatePassword(Integer studentNum, String studentPass)
            throws Exception {
        String sql = "UPDATE student_info  SET student_password=? where student_num=?";
        Connection conn = ConnUtil.getConn();
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1, studentPass);
        pstat.setInt(2, studentNum);
        int resultRows = pstat.executeUpdate();
        return resultRows > 0;
    }
}
