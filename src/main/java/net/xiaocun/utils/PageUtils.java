package net.xiaocun.utils;

/**
 * Created by Administrator on 2016/11/26.
 */
public class PageUtils {
    /**
     * 默认每页记录数
     */
    public static final int DEFAULT_PAGE_SIZE        = 10;
    public static final int DEFAULT_MAX_PAGE_SIZE    = 100;

    public static Integer getLimitOffset(Integer page, Integer pageSize) {
        return (getPageNo(page) - 1) * getPageSize(pageSize);
    }

    public static Integer getPageNo(Integer page) {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }

    /**
     * 获取每页记录数
     *
     * @param pageSize
     * @return
     */
    public static Integer getPageSize(Integer pageSize) {
        return getPageSize(pageSize, false);
    }

    /**
     * 获取每页记录数
     *
     * @param pageSize
     * @param checkMaxPageSize 是否检查最大记录数限制
     * @return
     */
    public static Integer getPageSize(Integer pageSize, boolean checkMaxPageSize) {
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        } else if (checkMaxPageSize && pageSize > DEFAULT_MAX_PAGE_SIZE) {
            pageSize = DEFAULT_MAX_PAGE_SIZE;
        }
        return pageSize;
    }
}
