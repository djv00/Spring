package cn.jy.service.impl;

import cn.jy.dao.UserDao;
import cn.jy.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
