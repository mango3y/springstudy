package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forw")
public class ForwardController {

    //http://localhost:8080/forw/test1
    @RequestMapping("/test1")
    public String test1(){
        System.out.println("testForward");
        //转发跳转页面 /views/users.jsp
        return "views/users"; //和下一行等价
        //return "forward:/views/users.jsp";
    }

    //http://localhost:8080/forw/test2
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("testForward2");
        //转发跳转到方法 /forw/test1
        //return "forward:test1"; //相对路径（转发到本类中的test1）
        //转发到 /forw/test1
        return "forward:/forw/test1"; //绝对路径
    }
}
