package cn.jy.service.impl;

import cn.jy.dao.UserDao;
import cn.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean id="userService" class="cn.jy.service.impl.UserServiceImpl"></bean>
//@Component("userService")
@Service("userService")
//@Scope("property")
//@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao"  ref="userDao"></property>
    @Autowired//按照数据类型从Spring容器中进行匹配的
    @Qualifier("userDao")//按照id值从容器中进行匹配的，但是注意此处@Qualifier需要结合@Autowired一起使用
    //@Resource(name="userDao")//@Resource相当于@Qualifier+@Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
        System.out.println(driver);
    }

/*    @PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Service对象的销毁方法");
    }*/
}
