<%--
  Created by IntelliJ IDEA.
  User: void3
  Date: 2024/7/31
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%-- http://localhost:8080/rest.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习REST风格</title>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
</head>
<body>
    <input type="button" value="queryAll" onclick="queryAll();">
    <input type="button" value="queryOne" onclick="queryOne();">
    <input type="button" value="deleteOne" onclick="deleteOne();">
    <input type="button" value="saveUser" onclick="saveUser();">
    <input type="button" value="updateUser" onclick="updateUser();">
    <script>
        function queryAll(){
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/users",
                success:function (ret){
                    console.log("查询所有：");
                    console.log(ret);
                }
            });
        }
        function queryOne(){
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/users/1",
                success:function (ret){
                    console.log("查询单个用户：");
                    console.log(ret);
                }
            });
        }
        function deleteOne(){
            $.ajax({
                type:"delete",
                url:"${pageContext.request.contextPath}/users/1",
                success:function (ret){
                    console.log("删除单个用户：");
                    console.log(ret);
                }
            });
        }
        function saveUser(){
            var user = {name:"shine", birth:"2020-12-12 12:12:20"};
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/users",
                data:JSON.stringify(user),
                contentType:"application/json",
                success:function (ret){
                    console.log("增加用户：");
                    console.log(ret);
                }
            });
        }
        function updateUser(){
            var user = {id:1, name:"zhangsan", birth:"2020-12-12 12:12:20"};
            $.ajax({
                type:"put",
                url:"${pageContext.request.contextPath}/users",
                data:JSON.stringify(user),
                contentType:"application/json",
                success:function (ret){
                    console.log("更新用户：");
                    console.log(ret);
                }
            });
        }
    </script>
</body>
</html>
