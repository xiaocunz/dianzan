package net.xiaocun.dao.impl;

import net.xiaocun.dao.BlogDao;
import net.xiaocun.model.Blog;
import net.xiaocun.utils.PageUtils;
import net.xiaocun.utils.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaocunzhang on 16/11/24.
 */
@Component
public class BlogDaoImpl  extends SqlMapClientDaoSupport implements BlogDao{
    private static final String NAME_SPACE = "BLOG.";
    private final SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();

    public Blog getByBlogId(long blogId) {
        return (Blog)sqlMapClientTemplate.queryForObject(NAME_SPACE + "QUERY-BLOG-BY-ID", blogId);
    }

    public List<Blog> getBlogs(Blog param, int page, int pageSize) {
        Map<String, Object> map = toMap(param);
        map.put("offset", PageUtils.getLimitOffset(page, pageSize));
        map.put("count", PageUtils.getPageSize(pageSize));
        return sqlMapClientTemplate.queryForList(NAME_SPACE + "QUERY-BLOG-BY-PARAM", map);
    }

    public long countByParam(Blog param) {
        Map<String, Object> map = toMap(param);
        return (Long) getSqlMapClientTemplate().queryForObject(NAME_SPACE + "COUNT-BLOG-BY-PARAM", map);
    }

    public Long insert(Blog blog) {
        return (Long) sqlMapClientTemplate.insert(NAME_SPACE + "INSERT-BLOG", blog);    }

    private Map<String, Object> toMap(Blog param) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (param.getId() > 0) {
            map.put("id",param.getId());
        }
        if (!StringUtils.isBlank(param.getTitle())) {
            map.put("title", "%" + param.getTitle() + "%");
        }

        if (param.getGlobalCategory() > 0) {
            map.put("globalCategory", param.getGlobalCategory());
        }

        if (param.getPersonalCategory() > 0) {
            map.put("personalCategory", param.getPersonalCategory());
        }

        if (!StringUtils.isBlank(param.getUserName())) {
            map.put("userName", param.getUserName());
        }
        return map;
    }
}
