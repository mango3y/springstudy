package cn.mango3y.springstudy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*记得在mvc.xml中配置拦截器*/
public class MyInterceptor implements HandlerInterceptor {

    //最重要的
    //在handler之前执行
    //再次定义handler中冗余的功能
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断登录状态
        HttpSession session = request.getSession();
        if(session.getAttribute("state")!=null){
            return true; //放行，执行后续的handler
        }
        //中断之前，响应请求
        response.sendRedirect("/login.jsp");
        return false;
    }

    //在handler之后，响应前执行
    //用于改动响应的数据，一般没啥用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //在视图渲染完毕后
    //一般用于做资源回收，一般没啥用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
