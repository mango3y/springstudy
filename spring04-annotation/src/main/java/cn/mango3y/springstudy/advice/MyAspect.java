package cn.mango3y.springstudy.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //声明此类是一个切面类：会包含 切入点pointcut 和 通知advice
@Component //声明组件，进入工厂
public class MyAspect {

    //定义切入点
    @Pointcut("execution(* cn.mango3y.springstudy.service.UserServiceImpl.*(..))")
    public void pc(){}

    @Before("pc()") //前置通知
    public void mybefore(JoinPoint a){
        System.out.println("target:" + a.getTarget());
        System.out.println("args:" + a.getArgs());
        System.out.println("method's name:" + a.getSignature().getName());
        System.out.println("before~~~~");
    }

    @AfterReturning(value = "pc()", returning = "ret") //后置通知
    public void myAfterReturning(JoinPoint a, Object ret){
        System.out.println("after~~~~:" + ret);
    }

    @Around("pc()") //环绕通知
    public Object myInterceptor(ProceedingJoinPoint p) throws Throwable{
        System.out.println("interceptor1~~~~");
        Object ret = p.proceed();
        System.out.println("interceptor2~~~~");
        return ret;
    }

    //将异常存储到ex中
    @AfterThrowing(value = "pc()", throwing = "ex") //异常通知
    public void myThrows(JoinPoint a, Exception ex){
        System.out.println("throws");
        System.out.println("====" + ex.getMessage());
    }
}
