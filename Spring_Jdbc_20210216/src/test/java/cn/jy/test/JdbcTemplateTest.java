package cn.jy.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

    @Test
    //���� JdbcTemplate ��������
    public void Test1() throws Exception {
        //��������Դ����
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("12345678");


        JdbcTemplate  jdbcTemplate =  new JdbcTemplate();
         //��������Դ����֪�����ݿ�����
        jdbcTemplate.setDataSource(dataSource);
        //ִ�в���
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom", 5000);
        System.out.printf(String.valueOf(row));
    }


    @Test
    //����Springȥ����jdbcTemplate����
    public void Test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate  jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?)", "lisi", 5000);
        System.out.printf(String.valueOf(row));
    }
}
