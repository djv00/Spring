package cn.jy.service.admin;

import cn.jy.entity.admin.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User findByUsername(String username);
}
