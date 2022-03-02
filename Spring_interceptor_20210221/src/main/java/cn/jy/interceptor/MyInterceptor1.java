package cn.jy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1  implements HandlerInterceptor {

    //在目标方法(show())执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle.......");
        String param = request.getParameter("param");
        if ("yes".equals(param)){
            return true;//返回true代表放行，返回false代表不放行，所以可以判断放不放行之后来转发或重定向，做登录验证等。。。
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);//返回false，不让通过，但是在之前，转发一下。
            return false;
        }
    }

    //在目标方法(show())执行之后，试图返回之前，执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //这里可以获取ModelAndView，可以把视图对象里面的属性改成其他的。我之前拼接的是modelAndView.addObject("name","itcast");
        modelAndView.addObject("name","daijiangyu");
        System.out.println("postHandle......");
    }

    //在整个流程都执行完毕后，执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //这里可以拿到Exception异常对象，这里用的比较少，用的最多的是第一个方法
        System.out.println("afterCompletion.....");
    }


}
