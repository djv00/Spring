package cn.jy.service.impl;

import cn.jy.dao.RoleDao;
import cn.jy.dao.UserDao;
import cn.jy.domain.Role;
import cn.jy.domain.User;
import cn.jy.service.UserService;

import java.util.List;

public class UserServiceimpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个roles数据
        for (User user :
                userList) {
            //获得user的id
            Long id = user.getId();
            //将id作为参数，查询当前userID对应的Role集合数据
           List<Role> roles =  roleDao.findRoleByUserID(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据
        Long userId = userDao.save(user);

        //第二步 向sys_user_role 关系表中存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        //1、删除sys_user_role关系表
            userDao.delUserRoleRel(userId);
        //2、删除sys_user表
            userDao.del(userId);
    }
}
