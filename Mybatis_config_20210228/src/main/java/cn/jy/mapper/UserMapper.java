package cn.jy.mapper;

import cn.jy.domain.User;

import java.util.List;

public interface UserMapper {
    public void save(User user);

    public User findById(int id);

    public List<User> findAll();
}
