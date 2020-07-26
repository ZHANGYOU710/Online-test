package cn.uu710.service;

import cn.uu710.dao.ClassInfoDao;
import cn.uu710.domain.ClassInfo;
import cn.uu710.util.ConnUtil;

import java.sql.SQLException;
import java.util.List;

public class ClassInfoService {
    private ClassInfoDao classInfoDao = new ClassInfoDao();

    public List<ClassInfo> findAll() {
        try {
            return classInfoDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ClassInfo classInfo) {
        try {
            boolean result = classInfoDao.add(classInfo);
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
            boolean result = classInfoDao.delete(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return false;
    }

    public boolean update(ClassInfo classInfo) {
        try {
            boolean result = classInfoDao.update(classInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return false;
    }

    public ClassInfo getById(Integer id) {
        try {
            ClassInfo classInfo = classInfoDao.getById(id);
            return classInfo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return null;
    }
}
