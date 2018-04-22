package com.cl.biz.Impl;

import com.cl.biz.UserService;
import com.cl.dao.UserDao;
import com.cl.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by one on 2018/4/22.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public User getUserbyname(String name) {
        return userDao.getUserbyname(name);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
