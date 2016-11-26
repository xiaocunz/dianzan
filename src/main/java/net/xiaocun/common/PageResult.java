package net.xiaocun.common;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class PageResult<T> {
    private List<T> data;
    private int page;
    private int pageSize;
    private long totalNulber;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNulber() {
        return totalNulber;
    }

    public void setTotalNulber(long totalNulber) {
        this.totalNulber = totalNulber;
    }
}
