package cn.jy.dao;

import cn.jy.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserID(Long id);
}
