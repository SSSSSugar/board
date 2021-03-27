<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/30
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="cn.bean.admin" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
    <script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
    </script>
</head>
<body>
    <div style="text-align: center;background: #393D49">
        <div style="margin:0 auto;width: 1200px;text-align: left">
            <ul class="layui-nav">
                <li class="layui-nav-item" >
                    <span style="color: #009688;font-size: 25px">在线备忘录</span>
                </li>
                <li class="layui-nav-item" style="float: right">
                    <a href="#">个人中心<span class="layui-badge-dot"></span></a>
                </li>
                <li class="layui-nav-item" style="float: right">
                    <a href="#"><span>管理员:<%=((admin)session.getAttribute("name")).getUsername()%></span>
                    <span class="layui-nav-more"></span>
                    </a>
                    <dl class="layui-nav-child layui-anim layui-anim-upbit"> <!-- 二级菜单 -->
                        <dd><a href="">修改信息</a></dd>
                        <dd><a href="">反馈错误</a></dd>
                        <dd><a href="">退了</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" style="float: right">


                </li>
            </ul>
        </div>
    </div>
</body>

</html>
