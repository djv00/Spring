package cn.jy.test;

import cn.jy.domain.User;
import cn.jy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private  UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }



    //增
    @Test
    public void save(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("abc");
        mapper.save(user);
    }

    //改
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(8);
        user.setUsername("aaaaaa");
        user.setPassword("abc");
        mapper.update(user);
    }

    //删
    @Test
    public void testDelete(){
        User user = new User();
        mapper.delete(8);
    }

    //查id
    @Test
    public void testFindById(){
        User user = mapper.findById(2);
        System.out.println(user);
    }

    //查所有
    @Test
    public void testfindAll(){
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
