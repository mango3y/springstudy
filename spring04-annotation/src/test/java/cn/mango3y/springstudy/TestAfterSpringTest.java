package cn.mango3y.springstudy;


import cn.mango3y.springstudy.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试启动:启动spring工厂，并当前测试类也会被下厂产
@RunWith(SpringJUnit4ClassRunner.class)
//对于ContextConfiguration，它属性locations的别名为value，所以也可以省略写为@ContextConfiguration("classpath:spring-context.xml")
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestAfterSpringTest {

    @Autowired
    @Qualifier("userDAO")
    //当前测试类也会被纳入工厂中，所以其中属性可以注入
    private UserDAO userDAO;

    @Test
    public void test(){
        System.out.println(userDAO.queryUsers());
    }

}
