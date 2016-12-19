package net.xiaocun.service;

import net.xiaocun.model.User;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface UserService {
    public User register(User user);
    public User getById(Long id);
    public User getByNickName(String nickName);
    public User authUser(String userName, String password);
}
