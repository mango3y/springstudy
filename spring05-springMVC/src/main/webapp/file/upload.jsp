<%--
  Created by IntelliJ IDEA.
  User: void3
  Date: 2024/7/29
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    file: <input type="file" name="source"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
