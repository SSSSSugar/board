<%@ page import="cn.bean.pwdnote" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.dao.userDao" %>
<%@ page import="cn.dao.impl.userDaoImpl" %>
<%@ page import="cn.bean.user" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/3
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线备忘录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
    <script src="${pageContext.request.contextPath}/layui/layui.all.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/layui/jquery.js" type="text/javascript"></script>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
        function del(id){
            var del = "delPwd";
            if (!confirm("确定要删除么")){
                return;
            }
            $.ajax({
                url:'http://localhost:8080/note/userServlet',
                async:true,
                type:'post',
                dataType:'json',
                data:{
                    id : id,
                    oper : del,
                },

            });
            location.reload(true);
            window.location.reload();

        }
    </script>
</head>
<body style="background: #F0F0F0">
<div>
    <jsp:include page="userHead.jsp"></jsp:include>
</div>
<div style="text-align: center;">
    <div style="text-align: left;width: 1200px;margin: 0 auto;">
        <div style="float: left">
            <jsp:include page="pwdLeft.jsp"></jsp:include>
        </div>
        <div  style="background: #F0F0F0;width: 1000px;float: left;text-align: center">
            <div style="width: 800px;margin: 0 auto">
                <h2 style="float: left;margin: 30px;margin-left: 0">修改密码本</h2>
                <table class="layui-table" lay-skin="line">
                    <colgroup>
                        <col width="35">
                        <col width="200">
                        <col width="50">
                        <col width="35">

                    </colgroup>
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>内容</th>
                        <th>记录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<pwdnote> notes = new ArrayList<pwdnote>();
                        userDao ud = new userDaoImpl();
                        String del = "delNote";
                        String upd = "updNote";
                        notes = ud.queryPwdnote(((user)session.getAttribute("name")).getUsername());
                    %>
                    <%
                        if (notes != null){
                            for (pwdnote note : notes){


                    %>
                    <tr>
                        <td><%=note.getPwdnoteid()%></td>
                        <td><%=note.getPwdnote()%></td>
                        <td><%=note.getTime()%></td>
                        <td><a href="/note/jsp/user/uPwd.jsp?id=<%=note.getPwdnoteid()%>"class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                            <a href="javascript:;" onclick="del(<%=note.getPwdnoteid()%>)" class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
                    </tr>


                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
