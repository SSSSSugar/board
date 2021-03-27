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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
</head>
<body style="text-align:center;background: #2F4056">
<script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript"></script>

<div style="width: 460px;margin:0 auto;background: #F0F0F0;margin-top: 200px;border-radius: 10px;height: 400px">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this" style="width: 200px">用户登录</li>
            <li style="width: 200px">管理员登录</li>
        </ul>
        <%
            //声明Java代码进行错误提示逻辑校验
            Object f = request.getAttribute("flag");
            if (f != null){%>
        <span style="color: red">用户名或密码错误！</span><br>
        <%
            }
        %>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <form action="loginServlet" method="post" name="login" class="layui-form" style="margin-top: 50px;margin-left: 30px">

                    <input type="hidden" name="oper" value="user">
                    <div class="layui-form-item">
                        <label class="layui-form-label">帐号</label>
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
                        <div class="layui-input-block">
                            <input type="submit" value="登录" class="layui-btn" style="float: left;width: 90px">
                            <input type="button" value="注册" onclick="reg()" class="layui-btn" style="float: left;width: 90px">
                        </div>
                    </div>
                </form>

            </div>
            <div class="layui-tab-item">

                <form action="loginServlet" method="post" name="login" class="layui-form" style="margin-top: 50px;margin-left: 30px">
                    <input type="hidden" name="oper" value="admin">
                    <div class="layui-form-item">
                        <label class="layui-form-label">帐号</label>
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
                        <div class="layui-input-block">
                            <input type="submit" value="登录" class="layui-btn" style="float: left;width: 90px">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function reg() {
        window.location = "/note/jsp/register.jsp";
    }

</script>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</html>
