package net.xiaocun.dao;

import net.xiaocun.model.Blog;

import java.util.List;

/**
 * Created by xiaocunzhang on 16/11/24.
 */
public interface BlogDao {
    public Blog getByBlogId(long blogId);

    public Blog getByUserId(long userId);

    public List<Blog> getBlogs(Blog param, int page, int pageSize);

    public long countByParam(Blog param);
}
