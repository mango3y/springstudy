package cn.mango3y.springstudy.resolver;

import cn.mango3y.springstudy.exception.MyException1;
import cn.mango3y.springstudy.exception.MyException2;
import cn.mango3y.springstudy.exception.MyException3;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常解析器(在mvc.xml中配置)
//任何一个Handler中抛出异常时
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if(ex instanceof MyException1){
            //error1.jsp
            modelAndView.setViewName("redirect:/error/error1.jsp");
        } else if(ex instanceof MyException2){
            //error2.jsp
            modelAndView.setViewName("redirect:/error/error1.jsp");
        } else if(ex instanceof MyException3){
            //error3.jsp
            modelAndView.setViewName("redirect:/error/error3.jsp");
        } else if(ex instanceof MaxUploadSizeExceededException){
            modelAndView.setViewName("redirect:/error/file_upload_error.jsp");
        }
        return modelAndView;
    }
}
