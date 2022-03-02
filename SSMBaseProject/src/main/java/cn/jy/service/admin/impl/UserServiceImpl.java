package cn.jy.service.admin.impl;

import cn.jy.dao.admin.UserDao;
import cn.jy.entity.admin.User;
import cn.jy.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
