<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/29
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线备忘录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">

</head>
<body style="text-align:center;background: #2F4056">
<script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript"></script>

    <div style="height: 500px;width: 460px;margin:0 auto;background: #F0F0F0;margin-top: 200px;border-radius: 10px;">
        <form action="/note/registerServlet" method="post" name="login" class="layui-form" style="margin: 40px;padding-top: 60px">
            <input type="hidden" name="oper" value="user">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input name="username" type="text" placeholder="请输入用户名：" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" placeholder="请输入密码" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="repassword" placeholder="请再次输入密码" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">二级密码</label>
                <div class="layui-input-inline">
                    <input name="secpwd" type="password" placeholder="二级密码：" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">真实姓名</label>
                <div class="layui-input-inline">
                    <input name="realname" type="text" placeholder="真实姓名：" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电子邮箱</label>
                <div class="layui-input-inline">
                    <input name="email" type="text" placeholder="电子邮箱：" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="submit" value="注册" class="layui-btn" style="float: left;width: 90px">
                    <input type="button" value="返回" onclick="ret()" class="layui-btn" style="float: left;width: 90px">
                </div>
            </div>
        </form>
    </div>
</body>
<script>
    function ret() {
        window.location = "/note/jsp/login.jsp";
    }
</script>

</html>