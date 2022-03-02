package cn.jy.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

    @Test
    //测试 JdbcTemplate 开发步骤
    public void Test1() throws Exception {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("12345678");


        JdbcTemplate  jdbcTemplate =  new JdbcTemplate();
         //设置数据源对象，知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom", 5000);
        System.out.printf(String.valueOf(row));
    }


    @Test
    //测试Spring去产生jdbcTemplate对象
    public void Test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate  jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?)", "lisi", 5000);
        System.out.printf(String.valueOf(row));
    }
}
