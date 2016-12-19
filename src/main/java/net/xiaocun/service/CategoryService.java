package net.xiaocun.service;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.Category;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface CategoryService {
    public Category getCategoryById(int id);

    public int countCategoryByParam(Category category);

    public PageResult<Category> getCategoryByPram(Category category, int page, int pageSize);
}
