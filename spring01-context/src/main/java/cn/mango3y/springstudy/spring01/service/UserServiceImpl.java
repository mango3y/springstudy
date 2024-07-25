package cn.mango3y.springstudy.spring01.service;

import cn.mango3y.springstudy.spring01.dao.UserDAO;
import cn.mango3y.springstudy.spring01.service.UserService;
import lombok.Getter;
import lombok.Setter;

public class UserServiceImpl implements UserService {
    // service中常用DAO，这里强耦合
    //UserDAO userDAO = new UserDAOImpl();

    // 不引用任何一个具体的组件（实现类），在需要其他组件的位置预留存取值入口(set/get)
    // 不再耦合任何DA0实现，消除不稳健因素
    @Getter
    @Setter
    //UserDAO userDAO;
    UserDAO userDAO;//根据自动注入的方式，会是不同的结果

    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);
    }

    // Getters And Setters
    // 为userDA0定义set/get,允许userDA0属性接收spring赋值
    // 引入lombok依赖后省略（在属性上用@Getter/@Setter，在类上用@Data）
//    public UserDAO getUserDAO() {
//        return userDAO;
//    }
//
//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
}
