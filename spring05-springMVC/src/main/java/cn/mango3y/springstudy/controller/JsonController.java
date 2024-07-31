package cn.mango3y.springstudy.controller;

import cn.mango3y.springstudy.entity.User;
import cn.mango3y.springstudy.entity.User2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/json")
public class JsonController {

    //http://localhost:8080/json/test1
    @RequestMapping("/test1")
    //@ResponseBody //把这个handler返回值自动转为json返回客户端，使用了@RestController后可注释掉
    public User2 test1(){
        System.out.println("test1");
        //return new User(1, "张三", new Date());
        //return new User2(1, "张三", "深圳", new Date(), 11451.4567);
        //页面的json为
        // {
        //    "NAME": "张三",
        //    "birth": "2024/07/29 08:08:13",
        //    "city": "深圳",
        //    "salary": "11451.46元"
        //}
        return new User2(1, null, null, new Date(), 11451.454);
        //{
        //    "NAME": "",
        //    "birth": "2024/07/29 08:11:33",
        //    "city": null,
        //    "salary": "11451.45元"
        //}
    }

    //http://localhost:8080/json/test2
    @RequestMapping("/test2")
    //@ResponseBody
    public List<User> test2(){
        System.out.println("test1");
        User user1 = new User(1, "张三", null);
        User user2 = new User(2, "李四", null);
        return Arrays.asList(user1, user2);
    }

    //http://localhost:8080/json/test3
    @RequestMapping(value = "/test3", produces = "text/html;charset=utf-8")//指定编码
    //test1/2里的人名之所以没有乱码是因为它们在进行json转换时已经帮我们设置好了字符集
    //而这个方法中返回的已经是字符串，没有json转换的过程，因此需要自己设置
    //@ResponseBody //本身不是字符串时才会把这个对象转为json字符串
    public String test3(){
        System.out.println("test3");
        //return "ok"; //已经是个字符串了，没必要再转为json，会直接把这个字符串返回给客户端
        return "你好"; //但返回的字符串为中文时，客户端上会显示乱码
        //解决办法就是再@RequestMapping加额外属性
    }

    //http://localhost:8080/data/json.jsp
    //将@Controller用@RestController代替，每个方法就可以省略@ResponseBody
    @RequestMapping(value = "test4", produces = "text/html;charset=utf-8")
    public String test4(@RequestBody User user){
        System.out.println("test4");
        System.out.println(user);
        return "你好，这是警告"; //出现乱码，记得在@RequestMapping加额外内容，才能恢复正常
    }
}
