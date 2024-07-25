package cn.mango3y.springstudy.spring01.dao;

public class UserDAOImpl implements UserDAO{
    @Override
    public void deleteUser(Integer id) {
        System.out.println("deleteUser of UserDAOImpl");
    }
}
