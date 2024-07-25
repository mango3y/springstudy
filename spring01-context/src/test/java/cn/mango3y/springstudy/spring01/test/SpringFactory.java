package cn.mango3y.springstudy.spring01.test;

import cn.mango3y.springstudy.spring01.entity.Student;
import cn.mango3y.springstudy.spring01.entity.User;
import cn.mango3y.springstudy.spring01.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFactory {
    @Test
    public void test01(){
        // 启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // 获取对象
        UserService userService = (UserService)context.getBean("userService");
        userService.deleteUser(1);
    }

    @Test
    public void test02(){
        // 启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // 获取对象
        User user = (User)context.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test03(){
        // 启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // 获取对象
        Student student = (Student)context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test04(){
        // 启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // 获取对象
        UserService userService = (UserService)context.getBean("userService3");
        userService.deleteUser(1);
    }

    @Test
    public void test05(){
        // 多例bean特点1：启动工厂时并不会被创建
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context2.xml");
        System.out.println("启动工厂后……");
        // 多例bean特点2：可以获取多个的Address类对象
        System.out.println("第一个Address对象……");
        context.getBean("address");
        System.out.println("第二个Address对象……");
        context.getBean("address");
        // 多例bean特点3：关闭工厂时，多例对象也并没有被销毁，而是由JVM垃圾回收机制决定何时回收
        System.out.println("即将关闭工厂……");
        context.close();
    }
}
