package cn.jy.test;

import cn.jy.domain.Order;
import cn.jy.domain.User;
import cn.jy.mapper.OrderMapper;
import cn.jy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        for (User user : userAndRoleAll) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
