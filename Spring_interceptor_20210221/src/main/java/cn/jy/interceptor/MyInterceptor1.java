package cn.jy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1  implements HandlerInterceptor {

    //��Ŀ�귽��(show())ִ��֮ǰִ��
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle.......");
        String param = request.getParameter("param");
        if ("yes".equals(param)){
            return true;//����true������У�����false�������У����Կ����жϷŲ�����֮����ת�����ض�������¼��֤�ȡ�����
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);//����false������ͨ����������֮ǰ��ת��һ�¡�
            return false;
        }
    }

    //��Ŀ�귽��(show())ִ��֮����ͼ����֮ǰ��ִ��
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //������Ի�ȡModelAndView�����԰���ͼ������������Ըĳ������ġ���֮ǰƴ�ӵ���modelAndView.addObject("name","itcast");
        modelAndView.addObject("name","daijiangyu");
        System.out.println("postHandle......");
    }

    //���������̶�ִ����Ϻ�ִ��
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //��������õ�Exception�쳣���������õıȽ��٣��õ������ǵ�һ������
        System.out.println("afterCompletion.....");
    }


}
