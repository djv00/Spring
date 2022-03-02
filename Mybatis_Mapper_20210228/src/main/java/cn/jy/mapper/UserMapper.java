package cn.jy.mapper;

import cn.jy.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findByConition(User user);

    public List<User> findByIds(List<Integer> ids);
}
