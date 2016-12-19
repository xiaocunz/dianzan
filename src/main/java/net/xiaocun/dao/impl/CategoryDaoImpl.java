package net.xiaocun.dao.impl;

import net.xiaocun.dao.CategoryDao;
import net.xiaocun.model.Category;
import net.xiaocun.utils.PageUtils;
import net.xiaocun.utils.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */
@Component
public class CategoryDaoImpl  extends SqlMapClientDaoSupport implements CategoryDao {
    private static final String NAME_SPACE = "CATEGORY.";
    private final SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
    public Category getById(int id) {
        return (Category) sqlMapClientTemplate.queryForObject(NAME_SPACE + "QUERY-CATEGORY-BY-ID", id);    }

    public List<Category> getCategorys(Category param, int page, int pageSize) {
        Map<String, Object> map = toMap(param);
        map.put("offset", PageUtils.getLimitOffset(page, pageSize));
        map.put("count", PageUtils.getPageSize(pageSize));
        return sqlMapClientTemplate.queryForList(NAME_SPACE + "QUERY-CATEGORY-BY-PARAM", map);
    }

    public int countByParam(Category param) {
        Map<String, Object> map = toMap(param);
        return (Integer) getSqlMapClientTemplate().queryForObject(NAME_SPACE + "COUNT-CATEGORY-BY-PARAM", map);
    }

    public int insert(Category category) {
        return (Integer) sqlMapClientTemplate.insert(NAME_SPACE + "INSERT-CATEGORY", category);
    }

    private Map<String, Object> toMap(Category param) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (param.getId() > 0) {
            map.put("id",param.getId());
        }
        if (!StringUtils.isBlank(param.getCode())) {
            map.put("code", param.getCode());
        }

        if (!StringUtils.isBlank(param.getName())) {
            map.put("name", param.getName());
        }

        if (param.getStatus() > 0) {
            map.put("status", param.getStatus());
        }

        if (param.getParentId() >= 0) {
            map.put("parentId", param.getParentId());
        }
        return map;
    }

}
