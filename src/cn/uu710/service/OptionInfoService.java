package cn.uu710.service;

import java.sql.SQLException;


import cn.uu710.dao.OptionInfoDao;
import cn.uu710.domain.OptionInfo;
import cn.uu710.util.ConnUtil;

public class OptionInfoService {
    private OptionInfoDao optionInfoDao = new OptionInfoDao();


    public int add(OptionInfo optionInfo) {
        try {
            return optionInfoDao.add(optionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return -1;
    }

    public int update(OptionInfo optionInfo) {
        try {
            return optionInfoDao.update(optionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return -1;
    }

    public OptionInfo getByNumIdAndType(Integer questionNumId, String optionType) {
        try {
            return optionInfoDao.getByNumIdAndType(questionNumId, optionType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
