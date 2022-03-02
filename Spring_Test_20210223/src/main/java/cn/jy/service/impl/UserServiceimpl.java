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
        //��װuserList�е�ÿһ��roles����
        for (User user :
                userList) {
            //���user��id
            Long id = user.getId();
            //��id��Ϊ��������ѯ��ǰuserID��Ӧ��Role��������
           List<Role> roles =  roleDao.findRoleByUserID(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //��һ�� ��sys_user���д洢����
        Long userId = userDao.save(user);

        //�ڶ��� ��sys_user_role ��ϵ���д洢��������
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        //1��ɾ��sys_user_role��ϵ��
            userDao.delUserRoleRel(userId);
        //2��ɾ��sys_user��
            userDao.del(userId);
    }
}
