package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //声明这是个控制器
@RequestMapping("/hello") //访问路径，等价于url=pattern
public class HelloController {

    @RequestMapping("/test1") //访问路径http://localhost:8080/hello/test1
    public String hello1(){
        System.out.println("hello world");
        return "index"; //由视图解析器解析，表示跳转到: /index.jsp
    }

    @RequestMapping("/test2") //访问路径http://localhost:8080/hello/test2
    public String hello2(){
        System.out.println("hello c9");
        return "views/hello"; //表示跳转到: /views/hello.jsp
    }
}
