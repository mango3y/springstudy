package cn.mango3y.springstudy.spring02.service;

import cn.mango3y.springstudy.spring02.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public List<User> queryUsers() {
//        System.out.println("事务控制");
//        System.out.println("日志打印");
        System.out.println("queryUsers");
        return new ArrayList<>();
    }

    @Override
    public Integer updateUser() {
//        System.out.println("事务控制");
//        System.out.println("日志打印");
        System.out.println("updateUser");
        return 1;
    }

    @Override
    public Integer saveUser() {
//        System.out.println("事务控制");
//        System.out.println("日志打印");
        System.out.println("saveUser");
        return 1;
    }

    @Override
    public Integer deleteUser() {
//        System.out.println("事务控制");
//        System.out.println("日志打印");
        System.out.println("deleteUser");
        return 1;
    }
}
