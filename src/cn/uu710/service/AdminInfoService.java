package cn.uu710.service;

import cn.uu710.dao.AdminInfoDao;
import cn.uu710.domain.AdminInfo;
import cn.uu710.util.ConnUtil;

import java.sql.SQLException;

public class AdminInfoService {
    private AdminInfoDao dao =new AdminInfoDao();
    /**
     * 根据用户名和密码判断用户是否存在
     * 如果存在，返回admininfo
     * 如果不存在，返回null。
     * @param adminName
     * @param adminPass
     * @return
     */
    public AdminInfo getByAdminNameAndPass(String adminName, String adminPass) {
        AdminInfo adminInfo;
        try {
            adminInfo = dao.getByAdminName(adminName);
            if (null != adminInfo) {
                if (null != adminInfo.getAdminPass()
                        && adminInfo.getAdminPass().equals(adminPass)) {
                    return adminInfo;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return null;

    }

    /**
     * 更新密码
     * @param adminName
     * @param adminPass
     * @return
     */
    public boolean updatePasswordByAdminName(String adminName, String adminPass) {
        try {
            int result = dao.updatePasswordByAdminName(adminName, adminPass);
            return result>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return false;
    }

    public AdminInfo getByAdminName(String adminName) {
        try {
            AdminInfo adminInfo = dao.getByAdminName(adminName);
            return adminInfo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();

        }
        return null;
    }

    public boolean update(AdminInfo adminInfo) {
        try {
            boolean result = dao.update(adminInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return false;
    }


}
