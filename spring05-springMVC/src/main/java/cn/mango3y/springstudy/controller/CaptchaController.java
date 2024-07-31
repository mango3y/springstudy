package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @RequestMapping("/test1")
    public String test1(String captcha, HttpSession session){
        //对比
        String realCap = (String)session.getAttribute("captcha");
        //忽略大小写
        if(realCap.equalsIgnoreCase(captcha)){
            return "index";
        }
        return "error_captcha";
    }
}
