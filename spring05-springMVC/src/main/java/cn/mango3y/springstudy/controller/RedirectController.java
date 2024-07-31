package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redir")
public class RedirectController {

    //http://localhost:8080/redir/test1
    @RequestMapping("/test1")
    public  String test1(){
        System.out.println("test redirect1");
        //重定向到
        return "redirect:/redir/users.jsp";//绝对路径
    }

    //http://localhost:8080/redir/test2
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("test redirect2");
        //重定向到 /redir/test1
        //return "redirect:test1" //相对路径（转发到本类中的test1）
        return "redirect:test1";
    }
}
