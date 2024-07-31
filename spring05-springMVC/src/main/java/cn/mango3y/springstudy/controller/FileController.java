package cn.mango3y.springstudy.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    //http://localhost:8080/file/upload.jsp
    @RequestMapping("/upload")
    //形参名要求与表单中文件的name一样
    //要能正常接收文件的话还得在mvc.xml中配置文件上传解析器
    public String upload(MultipartFile source, HttpSession session) throws IOException {
        //获取上传文件的原始文件名(包括后缀)
        String originalFilename = source.getOriginalFilename();
        //生成一个唯一的文件名
        String uniqueFilename = UUID.randomUUID().toString();
        //获取文件后缀/扩展名
        String extension = FilenameUtils.getExtension(originalFilename);
        //拼接完整的唯一文件名
        String uniqueFilename2 = uniqueFilename+"."+extension;

        //获取上传文件的类型
        //String contentType = source.getContentType();
        //System.out.println(originalFilename + ", " + contentType);

        //保存文件

        //绝对路径
        //source.transferTo(new File("D:\\Projects\\springstudy\\spring05-springMVC\\src\\main\\webapp\\files\\" + originalFilename));

        //相对路径，如果我要存放到webapp下的files目录要怎么做呢？
        //在形参列表中导入HttpSession
        //!注意：这个创建files目录之后不准未空，最好随便加个什么文件进去，因为若files目录为空，在部署时会忽略该目录。
        String realPath = session.getServletContext().getRealPath("/files");
        //System.out.println("realPath:" + realPath); //D:\Projects\springstudy\spring05-springMVC\target\spring05-springMVC\files
        source.transferTo(new File(realPath + "\\" + uniqueFilename2));
        return "index";
    }

    //http://localhost:8080/file/download.jsp
    @RequestMapping("download")
    public void download(String name, HttpSession session, HttpServletResponse response) throws IOException {
        String realPath = session.getServletContext().getRealPath("/files");
        String filePath = realPath + "\\" + name;
        //设置响应头，告知浏览器，要以附件的形式保存内容 filename=浏览器显示的下载文件
        response.setHeader("content-disposition", "attachment;filename="+name);
        //响应
        IOUtils.copy(new FileInputStream(filePath), response.getOutputStream());
    }


}
