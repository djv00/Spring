package cn.jy.service;

import cn.jy.domain.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
