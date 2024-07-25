package cn.mango3y.springstudy.spring01.test;

import cn.mango3y.springstudy.spring01.dao.UserDAO;
import cn.mango3y.springstudy.spring01.factory.MyFactory;
import cn.mango3y.springstudy.spring01.service.UserService;
import org.junit.Test;

import java.io.IOException;

public class MyFactoryTest {
    //自己去pom.xml导入junit
    @Test
    public void test01() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyFactory myFactory = new MyFactory("/bean.properties");
        UserDAO userDao = (UserDAO)myFactory.getBean("userDAO");
        UserService userService = (UserService)myFactory.getBean("userService");
        userDao.deleteUser(1);
        userService.deleteUser(2);
    }
}
