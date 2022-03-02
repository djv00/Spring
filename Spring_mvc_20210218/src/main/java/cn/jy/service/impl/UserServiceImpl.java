package cn.jy.service.impl;

import cn.jy.service.UserService;
import cn.jy.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
