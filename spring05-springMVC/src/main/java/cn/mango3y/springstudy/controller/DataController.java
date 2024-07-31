package cn.mango3y.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/data")
@SessionAttributes(names = {"city", "street"}) //names或者value无所谓
public class DataController {

    /*比较传统的方式，不再使用了*/
    //http://localhost:8080/data/test1
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpSession session){
        System.out.println("test1");
        request.setAttribute("name", "张三");
        session.setAttribute("age", 18);
        return "data/data";
    }

    //http://localhost:8080/data/test2
    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("gender", true); //model会把值复制到request中
        //如果要往session里面存值利用@SessionAttributes指定session域中键值对的键
        model.addAttribute("city", "广州");
        model.addAttribute("street", "北京路");
        return "data/data2";
    }

    //http://localhost:8080/data/test3
    //清空存入session域和request域中的数据
    @RequestMapping("/test3")
    public String test3(SessionStatus status){
        //清空所有通过model存入session域的数据
        status.setComplete();
        return "data/data2";
    }

    //http://localhost:8080/data/test4
    //利用ModelAndView进行传值
    @RequestMapping("/test4")
    public ModelAndView test4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/data/data3.jsp");
        mv.addObject("claz", "001");
        return mv;
    }
}
