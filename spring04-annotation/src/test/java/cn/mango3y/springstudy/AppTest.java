package cn.mango3y.springstudy;

import cn.mango3y.springstudy.entity.User;
import cn.mango3y.springstudy.service.UserService;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)context.getBean("userService");
        User user = new User(10018, "lisi", "897", false, new Date());
        userService.updateUser(user);
    }

    @Test
    public void testAOP() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)context.getBean("userService");
        userService.deleteUser(1);
    }
}
