package cn.mango3y.springstudy.spring01.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//工厂
//1、加载配置文件
//2、生产配置中记录的对象
public class MyFactory {
    private Properties properties = new Properties();

    public MyFactory() {
    }

    //建造工厂
    public MyFactory(String filePath) throws IOException {
        //一个获取resources内文件的输入流的方法
        InputStream is = MyFactory.class.getResourceAsStream(filePath);
        //读取配置文件
        properties.load(is);
    }

    //工厂生产对象
    public Object getBean(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1、通过name获取类路径
        // 比如输入userDA0则获取cn.mango3y.springstudy.dao.UserDAOImpl
        String classPath = properties.getProperty(name);
        //2、通过反射加载类
        Class clz = MyFactory.class.forName(classPath);
        //3、通过类对象生产对象
        return clz.newInstance();
    }
}
