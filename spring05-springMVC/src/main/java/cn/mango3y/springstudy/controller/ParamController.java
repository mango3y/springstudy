package cn.mango3y.springstudy.controller;

import cn.mango3y.springstudy.entity.User;
import cn.mango3y.springstudy.entity.UserList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

//学习：接收请求参数
@Controller
@RequestMapping("/param")
public class ParamController {

    //接收基本数据类型
    //http://localhost:8080/param/test1?id=1&name=xiaoma&gender=false&birth=2020-1-1%2000:00:00
    @RequestMapping("/test1")
    public String test1(Integer id, String name, Boolean gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date birth //可省略DateTimeFormat因为默认格式就是这个
    ){
        System.out.println("test1");
        System.out.println("id:" + id + " name:" + name + " gender:" + gender + " birth:" + birth);
        return "views/hello";
    }

    //接收实体
    //http://localhost:8080/param/test2?id=1&name=xiaoma&gender=false&birth=2020-1-1
    @RequestMapping("/test2")
    public String test2(User user){
        System.out.println("test2");
        System.out.println(user);
        return "views/hello";
    }

    //接收简单数组
    //访问 http://localhost:8080/param.jsp
    //由jsp页面表单提交过来
    @RequestMapping("/test3")
    public String test3(String[] hobby){
        System.out.println("test3");
        for (String h : hobby){
            System.out.println(h);
        }
        return "views/hello";
    }

    //集合收参【了解】（不常用）
    //http://localhost:8080/param/test4?user[0].id=1&user[0].name=zhang&user[0].birth=2001-01-01&user[0].gender=false&user[1].id=2...
    //但是以上的网址有特殊字符[]，是无法作为url的，所以得转为post提交
    //http://localhost:8080/param1.jsp
    @RequestMapping("/test4")
    public String test4(UserList userList){
        System.out.println("test4");
        for(User user : userList.getUsers()){
            System.out.println(user);
        }
        return "index";
    }

    //路径参数1
    //{id}定义名为id的路径;【/test5/{id}】的匹配能力和【/test5/*】等价
    //http://localhost:8080/param/test5/10 {id}匹配到10
    @RequestMapping("/test5/{id}")
    //@PathVariable将{id}路径匹配到值赋给id参数
    //路径名和参数名相同则@PathVariable("id")可简写为 @PathVariable
    public String test5(@PathVariable("id") Integer id){
        System.out.println("test5");
        System.out.println("id:" + id);
        return "index";
    }

    //路径参数1
    //http://localhost:8080/param/test6/tom {username}匹配到tom
    @RequestMapping("/test6/{username}")
    public String test6(@PathVariable("username") String name){
        System.out.println("test6");
        System.out.println("username:" + name);
        return "index";
    }

}
