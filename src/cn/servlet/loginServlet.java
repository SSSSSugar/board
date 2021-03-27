package cn.servlet;

import cn.bean.admin;
import cn.bean.user;
import cn.service.impl.loginServiceImpl;
import cn.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-30-15:33
 */
public class loginServlet extends HttpServlet {
    loginService ls = new loginServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=UTF-8");

        String oper = req.getParameter("oper");
        System.out.println(oper);
        switch (oper){
            case "user":
                try {
                    userLogin(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "admin":
                try {
                    adminLogin(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }

    private void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        admin admin = ls.checkAdminLogin(username,password);
        System.out.println(admin.getUsername());
        if (admin != null){
            HttpSession hs = req.getSession();
            hs.setAttribute("name",admin);
            req.getRequestDispatcher("/jsp/admin/main.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }
    }

    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        user user = ls.checkUserLogin(username,password);
        if (user != null){
            HttpSession hs = req.getSession();
            hs.setAttribute("name",user);
            req.getRequestDispatcher("/jsp/user/main.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }
    }
}
