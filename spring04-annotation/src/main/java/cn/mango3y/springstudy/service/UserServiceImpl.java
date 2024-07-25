package cn.mango3y.springstudy.service;

import cn.mango3y.springstudy.dao.UserDAO;
import cn.mango3y.springstudy.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
//可以给整个类事务控制注解
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Setter
    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO; //记得去spring-context.xml文件将userDAO注入到这里

    @Override
    //可以单独针对某个方法进行事务控制注解
    @Transactional(propagation = Propagation.SUPPORTS)
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
