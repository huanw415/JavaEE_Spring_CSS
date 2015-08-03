package com.tw.service;

import com.tw.dao.Dao;
import com.tw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Dao<User> userDao;

    public List<User> getAllUsers() {

        return userDao.getDataList(User.class);
    }

    public void createUser(User user) {
        userDao.createData(user);
    }

    public User getUserById(int id) {
        return userDao.getDataById(id, User.class);
    }

    public void deleteUser(User user) {
        userDao.deleteData(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

//    public List<User> getUsersByName(String name) {
//        return userDao.getUsersByName(name);
//    }
//
//    public String canLogIn(User user, String password) {
//        if (user.getPassword().equals(password)) {
//            return "密码正确";
//        } else {
//            return "密码错误";
//        }
//    }
}