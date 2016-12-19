package net.xiaocun.dao;

import net.xiaocun.model.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface CategoryDao {
    public Category getById(int id);

    public List<Category> getCategorys(Category param, int page, int pageSize);

    public int countByParam(Category param);

    public int insert(Category category);
}
