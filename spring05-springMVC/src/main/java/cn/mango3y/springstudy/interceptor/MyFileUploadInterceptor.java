package cn.mango3y.springstudy.interceptor;

import lombok.Setter;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//记得在mvc.xml中配置该拦截器
public class MyFileUploadInterceptor implements HandlerInterceptor {

    @Setter
    private Long maxFileUploadSize; //在mvc.xml拦截器配置中注入

    /*public void setMaxFileUploadSize(Long maxFileUploadSize) {
        this.maxFileUploadSize = maxFileUploadSize;
    }*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断上传文件大小 1048576
        ServletRequestContext servletRequestContext = new ServletRequestContext(request);
        //文件大小byte
        long l = servletRequestContext.contentLength(); //这个方法返回当前请求中上传文件的大小
        if(l < maxFileUploadSize){
            throw new MaxUploadSizeExceededException(maxFileUploadSize);//再在异常解析器中处理异常
        }
        return true;
    }
}
