package cn.jy.test;

import cn.jy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    //��ѯ����
    @Test
    public void Test1() throws IOException {
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //��ӡ���
        System.out.println(userList);
        //�ͷ���Դ
        sqlSession.close();
    }

    //�������
    @Test
    public void Test2() throws IOException {

        //ģ��user����
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");

        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.insert("userMapper.save",user);
        //mybatis ִ�и��²��� ��Ҫ�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }

    //�޸Ĳ���
    @Test
    public void Test3() throws IOException {

        //ģ��user����
        User user = new User();
        user.setId(7);
        user.setUsername("lucy");
        user.setPassword("123");

        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.update("userMapper.update",user);
        //mybatis ִ�и��²��� ��Ҫ�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }

    //ɾ������
    @Test
    public void Test4() throws IOException {

        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.delete("userMapper.delete",7);
        //mybatis ִ�и��²��� ��Ҫ�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }

    //��ѯһ����������
    @Test
    public void Test5() throws IOException {
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        //��ӡ���
        System.out.println(user);
        //�ͷ���Դ
        sqlSession.close();
    }
}
