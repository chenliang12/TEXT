package com.cl.dao;

import com.cl.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by one on 2018/4/20.
 */

public interface UserDao {
    User getUser(User user);
    User getUserbyname(String name);
    User getUserByid(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
