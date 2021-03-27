package cn.servlet;

import cn.bean.user;
import cn.service.impl.registerServiceImpl;
import cn.service.registerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-29-22:41
 */
public class registerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        user u = new user();
        registerService rs = new registerServiceImpl();
        //获取请求信息
        u.setUsername(req.getParameter("username"));
        u.setPassword(req.getParameter("password"));
        u.setSecpwd(req.getParameter("secpwd"));
        u.setRealname(req.getParameter("realname"));
        u.setEmail(req.getParameter("email"));
        System.out.println(u.getUsername() + ":" + u.getPassword());
        //处理请求信息
        boolean flag = false;
        try {
            flag = rs.register(u);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(flag);
        //获取session对象
        HttpSession hs = req.getSession();
        if (flag == true){
            hs.setAttribute("check","1");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);

        } else {
            hs.setAttribute("check", "0");
            resp.sendRedirect("/jsp/register.jsp");
        }
   }
}
