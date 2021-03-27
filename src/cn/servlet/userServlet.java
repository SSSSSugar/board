package cn.servlet;

import cn.bean.note;
import cn.bean.pwdnote;
import cn.service.impl.userServiceImpl;
import cn.service.userService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sugar
 * @create 2020-06-30-16:10
 */
public class userServlet extends HttpServlet {
    userService us = new userServiceImpl();
    String getTime(){

            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(day);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        String oper = req.getParameter("oper");
        System.out.println(oper);
        switch (oper){
            case "addNote":
                try {
                    addNote(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delNote":
                try {
                    delNote(req,resp);
                    System.out.println("第二个执行");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "updNote":
                try {
                    updNote(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "checkSecpwd":
                try {System.out.println("第二次");
                    checkSecpwd(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "addPwd":
                try {
                    addPwd(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delPwd":
                try {
                    delPwd(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "updPwd":
                try {
                    updPwd(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "secUpd":
                try {
                    sceUpd(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void sceUpd(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String username = req.getParameter("username");
        String swcpwd = req.getParameter("secpwd");
        boolean flag = us.updSec(username,swcpwd);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdMain.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/secUpd.jsp").forward(req,resp);
        }

    }

    private void updPwd(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        pwdnote pwdnote = new pwdnote();
        pwdnote.setPwdnoteid(Integer.parseInt(req.getParameter("id")));
        pwdnote.setPwdnote(req.getParameter("pwdnote"));
        pwdnote.setUsername(req.getParameter("username"));
        pwdnote.setTime(getTime());
        boolean flag = us.updPwd(pwdnote);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdMain.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/uPwd.jsp").forward(req,resp);
        }
    }

    private void delPwd(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean flag = us.delPwd(id);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdMain.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdUpd.jsp").forward(req,resp);
        }

    }

    private void addPwd(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        pwdnote pwdnote = new pwdnote();
        pwdnote.setPwdnote(req.getParameter("pwdnote"));
        pwdnote.setUsername(req.getParameter("username"));
        pwdnote.setTime(getTime());
        boolean flag = us.addPwd(pwdnote);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdMain.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdAdd.jsp").forward(req,resp);
        }
    }

    private void checkSecpwd(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String username = req.getParameter("username");
        String secpwd = req.getParameter("secpwd");
        System.out.println(username + ":" + secpwd);
        boolean flag = us.checkSecpwd(username,secpwd);
        System.out.println(flag);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/pwdMain.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/notePwd.jsp").forward(req,resp);
        }
    }

    private void updNote(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        note note = new note();
        note.setNoteid(Integer.parseInt(req.getParameter("id")));
        System.out.println(note.getNoteid());
        note.setNote(req.getParameter("note"));
        note.setUsername(req.getParameter("username"));
        note.setTime(getTime());
        boolean flag = us.updNote(note);
        System.out.println(flag+note.getNote());
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            System.out.println("111");
            req.getRequestDispatcher("/jsp/user/main.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/uNote.jsp").forward(req,resp);
        }


    }

    private void delNote(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        boolean flag = us.delNote(id);
        System.out.println(flag);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            System.out.println("111");
            req.getRequestDispatcher("/jsp/user/main.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/noteUpd.jsp").forward(req,resp);
        }
    }

    private void addNote(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        note note = new note();
        note.setNote(req.getParameter("note"));
        note.setUsername(req.getParameter("username"));
        note.setTime(getTime());
        System.out.println(note.getNote());
        boolean flag = us.addNote(note);
        if (flag == true){
            req.setAttribute("flag",1);
            //请求转发
            req.getRequestDispatcher("/jsp/user/main.jsp").forward(req,resp);
        }else {
            req.setAttribute("flag",0);
            //请求转发
            req.getRequestDispatcher("/jsp/user/noteAdd.jsp").forward(req,resp);
        }

    }


}
