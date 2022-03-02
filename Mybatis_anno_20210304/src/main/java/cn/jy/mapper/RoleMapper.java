package cn.jy.mapper;

import cn.jy.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("Select * from sys_user_role ur,sys_role r where ur.roleId=r.id And ur.userId=#{uid}")
    public List<Role> findByUid(int uid);
}
