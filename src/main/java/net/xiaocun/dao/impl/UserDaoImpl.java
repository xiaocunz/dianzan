package net.xiaocun.dao.impl;

import net.xiaocun.dao.UserDao;
import net.xiaocun.model.Blog;
import net.xiaocun.model.User;
import net.xiaocun.utils.PageUtils;
import net.xiaocun.utils.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */
@Component
public class UserDaoImpl  extends SqlMapClientDaoSupport implements UserDao {
    private final SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
    private static final String NAME_SPACE = "USER.";
    public Long insert(User user) {
        return (Long) sqlMapClientTemplate.insert(NAME_SPACE + "INSERT-USER", user);
    }

    public User getById(long id) {
        return (User) sqlMapClientTemplate.queryForObject(NAME_SPACE + "QUERY-USER-BY-ID", id);
    }

    public User getByNickName(String nickName) {
        return (User) sqlMapClientTemplate.queryForObject(NAME_SPACE + "QUERY-USER-BY-NICKNAME", nickName);
    }

    public User getUserByParam(User user) {
        Map param = toMap(user);
        return (User)sqlMapClientTemplate.queryForObject(NAME_SPACE + "QUERY-USER-BY-PARAM", param);
    }

    private Map<String, Object> toMap(User param) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (param.getId() > 0) {
            map.put("id",param.getId());
        }
        if (!StringUtils.isBlank(param.getUserName())) {
            map.put("userName", param.getUserName());
        }

        if (!StringUtils.isBlank(param.getPassword())) {
            map.put("password", param.getPassword());
        }

        if (!StringUtils.isBlank(param.getNickName())) {
            map.put("nickName", param.getNickName());
        }

        if (!StringUtils.isBlank(param.getTelphone())) {
            map.put("telphone", param.getTelphone());
        }

        if (!StringUtils.isBlank(param.getEmail())) {
            map.put("email", param.getEmail());
        }

        if (param.getStatus() > 0) {
            map.put("status", param.getStatus());
        }
        return map;
    }
}
