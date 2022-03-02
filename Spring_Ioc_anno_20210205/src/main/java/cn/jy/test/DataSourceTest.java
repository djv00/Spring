package cn.jy.test;

import cn.jy.cofig.SpringCofiguration;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    //测试手动创建c3p0数据源
    public void test1() throws Exception {
        ComboPooledDataSource   dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("12345678");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建druid数据源
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建c3p0数据源(加载配置文件形式)
    public void test3() throws Exception {
        //读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        //创建数据源对象   设置链接参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //获得资源
        Connection connection = dataSource.getConnection();
        //打印一下地址，证明是能获取得到的
        System.out.println(connection);
        //关闭资源
        connection.close();
    }

    @Test
    //测试Spring容器去产生c3p0数据源对象
    public void test04() throws Exception {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringCofiguration.class);
        DataSource dataSource = (DataSource)app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试Spring容器去产生druid数据源对象
    public void test05() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource druidDataSource = app.getBean(DruidDataSource.class);
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
