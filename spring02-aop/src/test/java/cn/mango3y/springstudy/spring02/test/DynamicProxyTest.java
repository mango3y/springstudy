package cn.mango3y.springstudy.spring02.test;

import cn.mango3y.springstudy.spring02.service.RentService;
import cn.mango3y.springstudy.spring02.service.RentServiceImpl;
import cn.mango3y.springstudy.spring02.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void testJDK(){
        //代理目标
        RentService rentService = new RentServiceImpl();

        //辅助功能
        InvocationHandler ih = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //帮房东做的辅助功能
                System.out.println("发布租房信息");
                System.out.println("带租客看房");
                //核心功能让房东做
                rentService.rent();
                return null;
            }
        };

        //动态生成 代理类
        //生成类需要：类加载器
        //生成代理类额外需要：被代理的目标业务类所实现的所有接口（因为我们需要代理类与业务类实现相同接口）
        //最后还需要我们刚刚创建的InvocationHandler调用处理器
        //由于我们的代理类底层也是接口RentService的实现类，因此可以用RentService强转接收
        RentService realProxy = (RentService)Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                rentService.getClass().getInterfaces(),
                ih);
        realProxy.rent();
    }

    @Test
    public void testCGlib(){
        //同样需要作为代理目标的业务类
        RentService rentService = new RentServiceImpl();

        //创建CGlib的核心对象
        Enhancer enhancer = new Enhancer();
        //让代理类称为业务类的子类，这样也能保持功能一致
        enhancer.setSuperclass(RentServiceImpl.class);
        //注意，这个时候的InvocationHandler不是JDK里的而是spring里的
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //帮房东做的辅助功能
                System.out.println("发布租房信息");
                System.out.println("带租客看房");
                //核心功能让房东做
                rentService.rent();
                return null;
            }
        });

        //动态生产代理类
        RentServiceImpl realProxy = (RentServiceImpl)enhancer.create();
        realProxy.rent();
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        //通过目标的beanid获得代理对象
        UserService proxy = (UserService)context.getBean("userService");
        System.out.println(proxy.getClass()); //class com.sun.proxy.$Proxy6，也就是说获取的对象其实是代理类对象
        System.out.println("===========");
        proxy.queryUsers();
        /*
            事务控制
            日志打印
            queryUsers
         */
        System.out.println("===========");
        proxy.deleteUser(); //并没有给这个方法
        /*
            deleteUser
         */
    }
}
