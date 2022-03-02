package cn.jy.controller.admin;

import cn.jy.entity.admin.User;
import cn.jy.service.admin.UserService;
import cn.jy.util.CpachaUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
*
* 系统操作类控制器
* */
@Controller
@RequestMapping("/system")
public class SystemController {

    /*@RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "system/index";
    }*/

    @Autowired
    private UserService userService;

    /*系统登录后的主页*/
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model){
        model.setViewName("system/index");
        return model;
    }

    /*系统登录后的欢迎页*/
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView model){
        model.setViewName("system/welcome");
        return model;
    }
    /*登录页面*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model){
        model.setViewName("/system/login");
        return model;
    }

    /*登录表单提交处理控制器*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> loginAct(User user,String cpacha,HttpServletRequest request){
        Map<String,String> ret = new HashMap<String,String>();
        if (user == null){
            ret.put("type","error");
            ret.put("msg","请填写用户信息!");
            return ret;
        }
        if (StringUtils.isEmpty(cpacha)){
            ret.put("type","error");
            ret.put("msg","请填写验证码!");
            return ret;
        }
        if (StringUtils.isEmpty(user.getUsername())){
            ret.put("type","error");
            ret.put("msg","请填写用户名!");
            return ret;
        }
        if (StringUtils.isEmpty(user.getPassword())){
            ret.put("type","error");
            ret.put("msg","请填写密码!");
            return ret;
        }
        Object loginCpacha = request.getSession().getAttribute("loginCpacha");
        if (loginCpacha == null){
            ret.put("type","error");
            ret.put("msg","会话超时！，请刷新页面");
            return ret;
        }
        if (!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
            ret.put("type","error");
            ret.put("msg","验证码错误!");
            return ret;
        }
        User findByUsername = userService.findByUsername(user.getUsername());
        if (findByUsername == null){
            ret.put("type","error");
            ret.put("msg","该用户名不存在!");
            return ret;
        }
        if (!user.getPassword().equals(findByUsername.getPassword())){
            ret.put("type","error");
            ret.put("msg","密码错误!");
            return ret;
        }

        request.getSession().setAttribute("admin",findByUsername);
        ret.put("type","success");
        ret.put("msg","登录成功!");

        return ret;
    }


    /*本系统所有的验证码均采用此方法*/
    @RequestMapping(value = "/get_cpacha",method = RequestMethod.GET)
    public void generateCpacha(
            @RequestParam(name = "vl",required = false,defaultValue = "4") Integer vcodeLen,
            @RequestParam(name = "w",required = false,defaultValue = "100") Integer width,
            @RequestParam(name = "h",required = false,defaultValue = "30") Integer height,
            @RequestParam(name = "type",required = true,defaultValue = "loginCpacha") String cpachaType,
            HttpServletRequest request,
            HttpServletResponse response){
        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen,width,height);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute(cpachaType,generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage,"gif",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
