<%--
  Created by IntelliJ IDEA.
  User: void3
  Date: 2024/7/26
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/param/test4" method="post">
        id: <input type="text" name="users[0].id"><br>
        name: <input type="text" name="users[0].name"><br>
        gender: <input type="text" name="users[0].gender"><br>
        <hr>
        id: <input type="text" name="users[1].id"><br>
        name: <input type="text" name="users[1].name"><br>
        gender: <input type="text" name="users[1].gender"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
