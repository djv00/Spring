package cn.jy.dao.admin;

import cn.jy.entity.admin.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByUsername(String username);

}
