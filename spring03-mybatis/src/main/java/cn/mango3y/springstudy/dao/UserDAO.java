package cn.mango3y.springstudy.dao;

import cn.mango3y.springstudy.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> queryUsers();
    public Integer insertUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
}
