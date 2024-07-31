package cn.mango3y.springstudy.controller;

import cn.mango3y.springstudy.exception.MyException1;
import cn.mango3y.springstudy.exception.MyException2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ex")
public class ExController {

    //http://localhost:8080/ex/test1?id=1
    @RequestMapping("test1")
    public String test1(Integer id){
        System.out.println("test1");
        //调用service时,可能会抛出 MyException1 MyException3
        if(id == 1){
            throw new MyException1("test ex1");
        }
        return "success";
    }

    //http://localhost:8080/ex/test2?id=1
    @RequestMapping("test2")
    public String test2(Integer id){
        System.out.println("test2");
        //调用service时,可能会抛出 MyException1 MyException2
        if(id == 1){
            throw new MyException2("test ex2");
        }
        return "success";
    }
}
