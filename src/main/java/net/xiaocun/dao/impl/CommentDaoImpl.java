package net.xiaocun.dao.impl;

import net.xiaocun.dao.CommentDao;
import net.xiaocun.model.Comment;
import net.xiaocun.utils.PageUtils;
import net.xiaocun.utils.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */
@Component
public class CommentDaoImpl extends SqlMapClientDaoSupport implements CommentDao {
    private final SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
    private static final String NAME_SPACE = "COMMENT.";
    public Long insert(Comment comment) {
        return (Long) sqlMapClientTemplate.insert(NAME_SPACE + "INSERT-COMMENT", comment);
    }

    public List<Comment> getCommentsByParam(Comment comment, int page, int pageSize) {
        Map<String, Object> map = toMap(comment);
        map.put("offset", PageUtils.getLimitOffset(page, pageSize));
        map.put("count", PageUtils.getPageSize(pageSize));
        return sqlMapClientTemplate.queryForList(NAME_SPACE + "QUERY-COMMENT-BY-PARAM", map);
    }

    public long countByParam(Comment param) {
        Map<String, Object> map = toMap(param);
        return (Long) getSqlMapClientTemplate().queryForObject(NAME_SPACE + "COUNT-COMMENT-BY-PARAM", map);
    }

    private Map<String, Object> toMap(Comment param) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (param.getId() > 0) {
            map.put("id",param.getId());
        }
        if (!StringUtils.isBlank(param.getUserName())) {
            map.put("userName", param.getUserName());
        }
        if (param.getBlogId() > 0) {
            map.put("blogId",param.getBlogId());
        }
        if (!StringUtils.isBlank(param.getContent())) {
            map.put("content", param.getContent());
        }
        if (param.getGmtCreated() != null) {
            map.put("gmtCreated", param.getGmtCreated());
        }

        if (param.getStatus() > 0) {
            map.put("status", param.getStatus());
        }
        return map;
    }
}
