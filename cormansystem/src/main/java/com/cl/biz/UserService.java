package com.cl.biz;

import com.cl.model.User;

/**
 * Created by one on 2018/4/22.
 */
public interface UserService {
    User getUser(User user);
    User getUserbyname(String name);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
