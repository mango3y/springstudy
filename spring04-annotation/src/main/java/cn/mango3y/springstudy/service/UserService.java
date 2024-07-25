package cn.mango3y.springstudy.service;

import cn.mango3y.springstudy.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<User> queryUsers();
    public Integer insertUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id) throws SQLException;
}
