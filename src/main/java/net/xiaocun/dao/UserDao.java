package net.xiaocun.dao;

import net.xiaocun.model.User;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface UserDao {
    public Long insert(User user);
    public User getById(long id);
    public User getByNickName(String nickName);
    public User getUserByParam(User user);
}
