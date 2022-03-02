package cn.jy.controller;


import cn.jy.domain.User;
import cn.jy.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running.....");
        return "success";
    }



    @RequestMapping("/quick2")
    public ModelAndView  save2(){
        /*
            Model:模型 作用封装数据
            View: 视图 作用展示数据
        * */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","djy");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;

    }


    @RequestMapping("/quick3")
    public ModelAndView  save3(ModelAndView modelAndView){
        //设置模型数据
        modelAndView.addObject("username","djy222222222");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;

    }

    @RequestMapping("/quick4")
    public String  save4(Model model){

        model.addAttribute("username","djy3333333");
        return "success";

    }
    @RequestMapping("/quick5")
    public String  save5(HttpServletRequest request){

        request.setAttribute("username","2021年2月10号了。。。。 ");
        return "success";

    }

    @RequestMapping("/quick6")
    public void  save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello djy..");
    }

    @RequestMapping("/quick7")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String  save7(){
        return "hellodjy222...";
    }

    @RequestMapping("/quick8")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String  save8(){
        return "{\"username\":\"zhangshan\",\"age\":18}";
    }

    @RequestMapping("/quick9")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String  save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json转换工具将对象转换成json格式的字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    //期望SpringMVC自动将User转换成json格式的字符串
    public User  save10() throws IOException {
        User user = new User();
        user.setUsername("wangwu");
        user.setAge(66);
        return user;
    }

    @RequestMapping("/quick11")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save11(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick12")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save12(User user) throws IOException {

        System.out.println(user);
    }

    @RequestMapping("/quick13")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save13(String[] shuzu) throws IOException {

        System.out.println(Arrays.asList(shuzu));//数组打印只会显示地址，为了演示方便使用Arrays.asList()方法将shuzu转化成一个集合打印。

    }

    @RequestMapping("/quick14")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save14(VO vo) throws IOException {

        System.out.println(vo);

    }

    @RequestMapping("/quick15")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save15(@RequestBody List<User> userList) throws IOException {

        System.out.println(userList);

    }

    @RequestMapping("/quick16")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save16(@RequestParam(value = "name",required = false,defaultValue = "daijiangyu") String username) throws IOException {
        System.out.println(username);
    }

    //localhost:8080/user/quick17/zhangsan
    @RequestMapping("/quick17/{username}")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }


    @RequestMapping("/quick18")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save18(Date date) throws IOException {
        System.out.println(date);
    }

    @RequestMapping("/quick19")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick20")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    @RequestMapping("/quick21")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save21(@CookieValue(value = "JSESSIONID") String jessionId) throws IOException {
        System.out.println(jessionId);
    }

    //编写文件上传代码
    @RequestMapping("/quick22")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save22(String username, MultipartFile upload,MultipartFile upload2 ) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = upload.getOriginalFilename();
        //将文件转移到具体位置并添加上文件的名称
        upload.transferTo(new File("/Users/djymac/Music"+originalFilename));
        //获得上传文件2的名称
        String originalFilename2 = upload.getOriginalFilename();
        //将文件2转移到具体位置并添加上文件的名称
        upload.transferTo(new File("/Users/djymac/Music"+originalFilename2));
    }

    //编写文件上传代码
    @RequestMapping("/quick23")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void  save23(String username, MultipartFile[] uploads) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile:
                uploads) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("/Users/djymac/Music"+originalFilename));
        }
    }
}
