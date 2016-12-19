package net.xiaocun.service.impl;

import net.xiaocun.dao.UserDao;
import net.xiaocun.model.User;
import net.xiaocun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public User register(User user) {
        Long userId = userDao.insert(user);
        user.setId(userId);
        return user;
    }

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public User getByNickName(String nickName) {
        return userDao.getByNickName(nickName);
    }

    public User authUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user = userDao.getUserByParam(user);
        return user;
    }
}
