package cn.uu710.vo;

import java.util.List;

/**
 * 分页对象
 *
 * @param <T> 要分页的实体类
 * @author guoguo
 */
public class PageVO<T> {
    //当前页
    private int page;
    //每页显示条数
    private int recordOfPage;
    //总页数
    // 计算公式:
    // ((recordCount - 1) / recordOfPage) + 1
    // ((总记录数 - 1) / 每页显示条数) + 1
    private int pageCount;
    //总记录数
    private int recordCount;
    //存储当前页的记录集合
    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecordOfPage() {
        return recordOfPage;
    }

    public void setRecordOfPage(int recordOfPage) {
        this.recordOfPage = recordOfPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
