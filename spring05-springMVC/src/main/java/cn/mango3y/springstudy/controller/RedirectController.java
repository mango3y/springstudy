package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redir")
public class RedirectController {

    @RequestMapping("/test1")
    public  String testRedirect1(){
        System.out.println("test redirect1");
        //重定向到 /redir/test1
        //return "redirect:test1" //相对路径（转发到本类中的test1）
        return "redirect:/redir/test1";//绝对路径
    }

    @RequestMapping("/test2")
    public String testRedirect2(){
        System.out.println("test redirect2");
        //重定向到 /views/users.jsp
        return "redirect:/views/users.jsp";
    }
}
