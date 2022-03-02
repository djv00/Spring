package cn.jy.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        //读取Web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLoncation");

        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //将Spring的应用上下文对象存储到ServletContext域中
        servletContext.setAttribute("app",app);
        System.out.println("spring容器创建完毕..... ");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
