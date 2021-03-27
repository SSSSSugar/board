<%@ page import="cn.bean.user" %>
<%@ page import="cn.dao.userDao" %>
<%@ page import="cn.dao.impl.userDaoImpl" %>
<%@ page import="cn.bean.note" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/3
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>在线备忘录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
    <script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
</head>
<body style="background: #F0F0F0">
<div>
    <jsp:include page="userHead.jsp"></jsp:include>
</div>
<div style="text-align: center;">
    <div style="text-align: left;width: 1200px;margin: 0 auto;">
        <div style="float: left">
            <jsp:include page="userLeft.jsp"></jsp:include>
        </div>
        <div  style="background: #F0F0F0;width: 1000px;float: left;text-align: center">
            <div style="width: 800px;margin: 0 auto">
                <h2 style="float: left;margin: 30px;margin-left: 0">修改备忘录</h2>
                <form class="layui-form" action="/note/userServlet" method="post">
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        userDao us = new userDaoImpl();
                        note n = us.queryNoteById(id);

                    %>
                    <input type="hidden" name="oper" value="updNote">
                    <input type="hidden" name="id" value="<%=id%>">
                    <input type="hidden" name="username" value="<%=((user)session.getAttribute("name")).getUsername()%>">
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">文本域</label>
                        <div class="layui-input-block">
                            <textarea name="note" class="layui-textarea"><%=n.getNote()%></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





</body>
</html>
