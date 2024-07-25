package cn.mango3y.springstudy.service;

import cn.mango3y.springstudy.dao.UserDAO;
import cn.mango3y.springstudy.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Setter
    private UserDAO userDAO; //记得去spring-context.xml文件将userDAO注入到这里
    @Override
    public List<User> queryUsers() {
        return userDAO.queryUsers();
    }

    @Override
    public Integer insertUser(User user) {
        return userDAO.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public Integer deleteUser(Integer id){
        Integer i = userDAO.deleteUser(id);
        //制造运行时异常事故
        //int a = 10/0;

        //制造非运行时异常事故
//        if(1 == 1){
//            throw new SQLException("test 事务");
//        }

        //将非运行时异常转为运行时
//        if(1 == 1){
//            try{
//                throw new SQLException("test 事务");
//            } catch (SQLException e){
//                e.printStackTrace();
//                throw new RuntimeException("test 事务！！！");
//            }
//        }

        return i;
    }
}
