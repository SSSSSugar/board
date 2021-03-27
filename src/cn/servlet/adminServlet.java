package cn.servlet;

import cn.service.adminService;
import cn.service.impl.adminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:09
 */
public class adminServlet extends HttpServlet {
    adminService as = new adminServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        String oper = req.getParameter("oper");
        switch (oper){
            case "checkUser":
                try {
                    checkUser(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delUser":
                try {
                    delUser(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
                

        }
    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("username");
        boolean flag = as.delUser(name);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/admin/adminDel.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/admin/adminDel.jsp").forward(req,resp);
        }
    }

    private void checkUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List list = as.queryUser();

    }
}
