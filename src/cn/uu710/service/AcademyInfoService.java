package cn.uu710.service;

import cn.uu710.dao.AcademyInfoDao;
import cn.uu710.domain.AcademyInfo;
import cn.uu710.util.ConnUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * 学院信息servcie
 */
public class AcademyInfoService {
    private AcademyInfoDao dao = new AcademyInfoDao();

    public List<AcademyInfo> findAll() {
        try {
            return dao.findAll();
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return null;
    }

    public int deleteById(Integer id) {
        try {
            return dao.deleteById(id);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int add(AcademyInfo academyInfo) {
        try {
            return dao.add(academyInfo);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(AcademyInfo academyInfo) {
        try {
            return dao.update(academyInfo);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public AcademyInfo getById(int id) {
        try {
            return dao.getById(id);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
