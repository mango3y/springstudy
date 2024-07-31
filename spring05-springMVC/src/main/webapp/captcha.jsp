<%--
  Created by IntelliJ IDEA.
  User: void3
  Date: 2024/7/31
  Time: 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习验证码</title>
</head>
<body>
<%-- http://localhost:8080/captcha.jsp --%>
<%--还可以利用style调整图片大小--%>
<%--可以绑定点击事件以刷新验证码--%>
<form action="${pageContext.request.contextPath}/captcha/test1">
    <img src="${pageContext.request.contextPath}/captcha" style="width: 100px" onclick="refresh();">
    <input type="text" name="captcha"/>
    <br>
    <input type="submit" value="提交">
</form>

<script>
    function refresh(){
        var img = document.getElementById("cap");
        img.src="${pageContext.request.contextPath}/captcha?" + new Date().getTime();
        /*在后面加时间防止浏览器缓存*/
    }
</script>

</body>
</html>
