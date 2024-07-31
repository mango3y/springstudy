package cn.mango3y.springstudy.controller;

import cn.mango3y.springstudy.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/*
* 查询：所有用户
*      查询id=xx的某个用户
* 删除：id=xx某个用户
* 增加：在所有用户中增加一个
* 修改：在所有用户中修改一个
*
* 以上行为涉及两类资源：对于所有用户/users、对于id=xx的某个用户/users/{id}
* */
@RestController //在REST风格的设计中更喜欢用json通信，因此用这个
public class MyRestController {

    @GetMapping("/users")
    public List<User> queryUsers(){
        System.out.println("query users with get");
        User user1 = new User(1, "张三");
        User user2 = new User(2, "李四");
        return Arrays.asList(user1, user2);
    }

    @GetMapping("/users/{id}")
    public User queryOne(@PathVariable Integer id){
        System.out.println("query one user with get: " + id);
        return new User(1, "张三");
    }

    @DeleteMapping("/users/{id}")
    public String deleteOne(@PathVariable Integer id){
        System.out.println("delete one user with get: " + id);
        return "ok";
    }

    @PostMapping("/users")
    public String saveOne(@RequestBody User user){
        System.out.println("save one user with get: " + user);
        return "ok";
    }

    @PutMapping("/users")
    public String updateOne(@RequestBody User user){
        System.out.println("update one user with get: " + user);
        return "ok";
    }
}
