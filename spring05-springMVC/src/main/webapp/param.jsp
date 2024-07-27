<%--
  Created by IntelliJ IDEA.
  User: void3
  Date: 2024/7/26
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/param/test3">
        <input type="checkbox" name="hobby" value="football"> 足球
        <input type="checkbox" name="hobby" value="basketball"> 篮球
        <input type="checkbox" name="hobby" value="volleyball"> 排球
        <input type="submit" value="提交">
    </form>
</body>
</html>
