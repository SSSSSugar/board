<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/30
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线备忘录</title>
</head>
<body>
<form action="" method="post" name="login">
    <input name="username" type="text" placeholder="用户名：">
    <input name="password" type="password" placeholder="密码：">
    <input type="submit" value="登录">
    <input type="button" value="注册" onclick="reg()">
</form>
</body>
<script>
    function reg() {
        window.location = "/register.jsp";
    }

</script>
</html>
