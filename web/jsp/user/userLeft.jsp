<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/2
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<div style="background: #393D49;width: 200px;height: 93.6%">
    <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item"><a href="/note/jsp/user/main.jsp">查看备忘录</a></li>
        <li class="layui-nav-item">
            <a href="#">管理备忘录</a>
            <dl class="layui-nav-child">
                <dd><a href="/note/jsp/user/noteAdd.jsp">添加备忘录</a></dd>
                <dd><a href="/note/jsp/user/noteUpd.jsp"> 修改备忘录</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/note/jsp/user/notePwd.jsp">管理密码本</a></li>
    </ul>
</div>
</body>
</html>
