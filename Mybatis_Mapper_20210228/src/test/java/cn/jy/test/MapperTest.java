package cn.jy.test;

import cn.jy.domain.User;
import cn.jy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void Test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //模拟条件User
        User condition = new User();
        condition.setId(1);
        //condition.setUsername("zhangsan");
        //condition.setPassword("123");

       //List<User> userList = mapper.findByConition(condition);

        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }

}
