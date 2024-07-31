package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//学习拦截器
@Controller
@RequestMapping("/inter")
@SessionAttributes("state")
public class InterController {

    /* 结合拦截器MyInterceptor后，直接访问 /inter/test1 与 /inter/test1 会被转到login.jsp；
       必须要先访问/inter/login后再访问它们才可行
    */

    //http://localhost:8080/inter/login
    @RequestMapping("/login")
    public String login(Model model){
        // 登录后留取状态标记
        model.addAttribute("state","ok");
        return "index"; //转到首页
    }

    //http://localhost:8080/inter/test1
    @RequestMapping("/test1")
    public String test1(Model model){
        // 判断登录状态
        System.out.println("执行service11");
        return "index";
    }

    //http://localhost:8080/inter/test2
    @RequestMapping("/test2")
    public String test2(Model model){
        // 判断登录状态
        System.out.println("执行service22");
        return "index";
    }
}
