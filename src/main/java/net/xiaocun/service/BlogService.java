package net.xiaocun.service;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.Blog;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public interface BlogService {
    public Blog getBlogById(Long id);

    public long countBlogByParam(Blog blog);

    public PageResult<Blog> getBlogByPram(Blog blog, int page, int pageSize);
}
