<%@ page import="java.util.List" %>
<%@ page import="cn.bean.user" %>
<%@ page import="cn.dao.impl.adminDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.dao.adminDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/30
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线备忘录</title>
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
<body style="background: #F0F0F0">
    <div>
        <jsp:include page="adminHead.jsp"></jsp:include>
    </div>
    <div style="text-align: center;">
        <div style="text-align: left;width: 1200px;margin: 0 auto;">
            <div style="float: left">
                <jsp:include page="adminLeft.jsp"></jsp:include>
            </div>
            <div style="background: #F0F0F0;width: 1000px;float: left;text-align: center">
               <div style="width: 800px;margin: 0 auto">
                   <h2 style="float: left;margin: 30px;margin-left: 0">用户列表</h2>
                   <table class="layui-table" lay-skin="line">
                       <colgroup>
                           <col width="150">
                           <col width="200">
                           <col width="200">
                           <col width="200">
                           <col width="300">

                       </colgroup>
                       <thead>
                       <tr>
                           <th>用户名</th>
                           <th>密码</th>
                           <th>二级密码</th>
                           <th>真实姓名</th>
                           <th>邮箱</th>
                       </tr>
                       </thead>
                       <tbody>
                       <%
                           List<user> users = new ArrayList<user>();
                           adminDao ad = new adminDaoImpl();
                           users = ad.queryUser();
                       %>
                       <%
                           if (users != null){
                               for (user user : users){


                       %>
                       <tr>
                           <td><%=user.getUsername()%></td>
                           <td><%=user.getPassword()%></td>
                           <td><%=user.getSecpwd()%></td>
                           <td><%=user.getRealname()%></td>
                           <td><%=user.getEmail()%></td>
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
