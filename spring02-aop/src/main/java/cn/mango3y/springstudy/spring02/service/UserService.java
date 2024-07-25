package cn.mango3y.springstudy.spring02.service;

import cn.mango3y.springstudy.spring02.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUsers();
    Integer updateUser();
    Integer saveUser();
    Integer deleteUser();
}
