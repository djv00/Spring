package cn.jy.cofig;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//这个注解就是标志该类是Spring的核心配置类
@Configuration
/*<!--    配置组件扫描-->
<context:component-scan base-package="cn.jy"/>*/
//使用注解代替
@ComponentScan("cn.jy")
//<import resource=""/>引入分配置文件，用import
@Import({DataSourceConfiguration.class})//里面是一个数组{xxx1.class,xxx2.class}
public class SpringCofiguration {


}
