package net.xiaocun.service.impl;

import net.xiaocun.common.PageResult;
import net.xiaocun.dao.BlogDao;
import net.xiaocun.model.Blog;
import net.xiaocun.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;

    public Blog getBlogById(Long id) {
        return blogDao.getByBlogId(id);
    }

    public long countBlogByParam(Blog blog) {
        return blogDao.countByParam(blog);
    }

    public PageResult<Blog> getBlogByPram(Blog blog, int page, int pageSize) {
        PageResult<Blog> result = new PageResult<Blog>();
        result.setPage(page);
        result.setPageSize(pageSize);
        long total = blogDao.countByParam(blog);
        List<Blog> data = blogDao.getBlogs(blog, page, pageSize);
        result.setTotalNulber(total);
        result.setData(data);
        return result;
    }

    public Blog writeBlog(Blog blog) {
        Long blogId = blogDao.insert(blog);
        blog.setId(blogId);
        return blog;
    }
}
