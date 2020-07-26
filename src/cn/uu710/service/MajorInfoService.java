package cn.uu710.service;

import cn.uu710.dao.MajorInfoDao;
import cn.uu710.domain.MajorInfo;
import cn.uu710.vo.PageVO;

import java.sql.SQLException;
import java.util.List;

public class MajorInfoService {
    private MajorInfoDao dao = new MajorInfoDao();

    public PageVO<MajorInfo> search(int page, int recordOfPage) {
        try {
            List<MajorInfo> list= dao.search(page, recordOfPage);
            int recordCount=dao.getRecordCount();
            int pageCount=((recordCount - 1) / recordOfPage) + 1;
            if(page<1){
                page=1;
            }
            if(page>pageCount){
                page=pageCount;
            }

            PageVO pageVO=new PageVO();
            pageVO.setRecordOfPage(recordOfPage);
            pageVO.setList(list);
            pageVO.setRecordCount(recordCount);
            pageVO.setPageCount(pageCount);
            pageVO.setPage(page);

            return pageVO;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MajorInfo getById(Integer id) {
        try {
            return dao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(MajorInfo majorInfo) {
        try {
            return dao.add(majorInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int delete(int id) {
        try {
            return dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int logicDelete(int id) {
        try {
            return dao.logicDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(MajorInfo majorInfo) {
        try {
            return dao.update(majorInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<MajorInfo> findAll() {
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

