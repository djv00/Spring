package cn.jy.test;

import cn.jy.cofig.SpringCofiguration;
import cn.jy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//使用xml配置文件
//@ContextConfiguration("classpath:applicationContext.xml")
//使用核心配置类
@ContextConfiguration(classes = {SpringCofiguration.class})
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;
    @Test
    public void test1() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
