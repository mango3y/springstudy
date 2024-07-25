package cn.mango3y.springstudy;

import cn.mango3y.springstudy.dao.UserDAO;
import cn.mango3y.springstudy.entity.User;
import cn.mango3y.springstudy.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestSpringMyBatis {
    @Test
    public void testAfterSqlSessionFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        List<User> users = mapper.queryUsers();
        for (User user : users){
            System.out.println(user);
        }
        //这个方法还是比较麻烦，但在spring工厂引入MapperScannerConfigurer的bean后，事情就会变得很简单
    }

    @Test
    public void testAfterMapperScannerConfigurer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserDAO userDAO = (UserDAO)context.getBean("userDAO");
        List<User> users = userDAO.queryUsers();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)context.getBean("userService");
        for(User user : userService.queryUsers()){
            System.out.println(user);
        }
    }

    @Test
    public void testTxManage() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)context.getBean("userService");
        //userService.deleteUser(10012);
        User user = new User(null, "小陈", "123", true, new Date());
        Integer i = userService.insertUser(user); //返回的数字其实是插入成功的行数，1
        //输出1表示插入成功
        System.out.println(i);
        System.out.println(user); //User(id=10022, username=xiaojun, password=123, gender=false, registerTime=Thu Jul 25 23:51:48 CST 2024)
        //因此，如果要想service返回插入成功后user的主键id值则从user对象中获取
    }

}
