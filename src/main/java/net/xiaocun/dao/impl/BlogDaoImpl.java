package net.xiaocun.dao.impl;

import net.xiaocun.dao.BlogDao;
import net.xiaocun.model.Blog;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

/**
 * Created by xiaocunzhang on 16/11/24.
 */
public class BlogDaoImpl  extends SqlMapClientDaoSupport implements BlogDao{
    private static final String NAME_SPACE = "blog.";
    private final SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();

    public Blog getByBlogId(long blogId) {
        return (Blog)sqlMapClientTemplate.queryForObject(NAME_SPACE + "queryByBlogId", blogId);
    }

    public Blog getByUserId(long userId) {
        return null;
    }

    public List<Blog> getBlogs() {
        return sqlMapClientTemplate.queryForList(NAME_SPACE + "queryBlogs");
    }
}
