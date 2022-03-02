package cn.jy.dao.Impl;

import cn.jy.dao.UserDao;
import cn.jy.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao   {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll(){
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {
        //jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        //����PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //ʹ��ԭʼ��jdbc��ɼ���PreparedStatement���齨
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());
                return preparedStatement;

            }
        };
        //����keyHolder
        GeneratedKeyHolder keyHolder =new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        //������ɵ�����
        long userId = keyHolder.getKey().longValue();
        return userId;//���ص�ǰ������û���id��id�����ݿ��Զ����ɵ�
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {

        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=? ",userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }
}
