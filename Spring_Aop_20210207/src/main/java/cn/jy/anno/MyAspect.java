package cn.jy.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注当前的MyAspect是一个切面
public class MyAspect {

    //@Before("execution(* cn.jy.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强");
    }

    public void afterReturnling() {
        System.out.println("后置增强");
    }

    //Proceeding JoinPoint 正在执行的连接点 == 切点
    //@Around("execution(* cn.jy.anno.*.*(..))")
    //第一种引用方式
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强.....");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后增强.....");
        return proceed;
    }
    public void afterThrowing () {
        System.out.println("异常抛出增强.....");
    }
    //@After("execution(* cn.jy.anno.*.*(..))")
    //第二种引用方式
    @After("MyAspect.pointcut()")
    public void after () {
        System.out.println("最终增强.....");
    }

    //定义一个切点表达式方法
    @Pointcut("execution(* cn.jy.anno.*.*(..))")
    public void pointcut(){};
}
