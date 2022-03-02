package cn.jy.proxy.cglib;

import cn.jy.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        //建立目标对象
        Target target = new Target();

        //获得增强对象
        Advice advice = new Advice();

        //返回值 就是动态生成的代理对象  基于cgLib
        //1. 创建增强器
        Enhancer enhancer = new Enhancer();
        //2. 设置父类(目标)
        enhancer.setSuperclass(Target.class);
        //3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterReturning();//执行后置
                return null;
            }
        });

        //4. 创建代理对象
        Target proxy = (Target) enhancer.create();//代理对象与目标对象是父子关系。所以可以用Target接受。

        //5. 测试
        proxy.save();
    }
}
