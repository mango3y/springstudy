package cn.mango3y.springstudy.spring02.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

//前置通知类
public class MyAdvice implements MethodBeforeAdvice {//实现前置通知接口
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //辅助功能
        System.out.println("事务控制");
        System.out.println("日志打印");
    }
}
