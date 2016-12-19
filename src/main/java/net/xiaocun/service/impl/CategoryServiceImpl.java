package net.xiaocun.service.impl;

import net.xiaocun.common.PageResult;
import net.xiaocun.dao.CategoryDao;
import net.xiaocun.model.Category;
import net.xiaocun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    public Category getCategoryById(int id) {
        return categoryDao.getById(id);
    }

    public int countCategoryByParam(Category category) {
        return categoryDao.countByParam(category);
    }

    public PageResult<Category> getCategoryByPram(Category category, int page, int pageSize) {
        PageResult<Category> result = new PageResult<Category>();
        result.setPage(page);
        result.setPageSize(pageSize);
        long total = categoryDao.countByParam(category);
        List<Category> data = categoryDao.getCategorys(category, page, pageSize);
        result.setTotalNulber(total);
        result.setData(data);
        return result;
    }
}
