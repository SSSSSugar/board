package cn.service.impl;

import cn.bean.note;
import cn.bean.pwdnote;
import cn.dao.impl.userDaoImpl;
import cn.dao.userDao;
import cn.service.userService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:11
 */
public class userServiceImpl implements userService {
    userDao ud = new userDaoImpl();
    @Override
    public boolean addNote(note note) throws SQLException {
        return ud.addNote(note);
    }

    @Override
    public boolean delNote(int id) throws SQLException {
        return ud.delNote(id);
    }

    @Override
    public boolean updNote(note note) throws SQLException {
        return ud.updNote(note);
    }

    @Override
    public List<note> queryNote(String username) throws SQLException {
        return ud.queryNote(username);
    }

    @Override
    public boolean checkSecpwd(String username, String secpwd) throws SQLException {
        return ud.checkSecpwd(username,secpwd);
    }

    @Override
    public boolean addPwd(pwdnote pwdnote) throws SQLException {
        return ud.addPwd(pwdnote);
    }

    @Override
    public boolean delPwd(int id) throws SQLException {
        return ud.delPwd(id);
    }

    @Override
    public boolean updPwd(pwdnote pwdnote) throws SQLException {
        return ud.updPwd(pwdnote);
    }

    @Override
    public List<pwdnote> queryPwdnote(String username) throws SQLException {
        return ud.queryPwdnote(username);
    }

    @Override
    public boolean updSec(String name, String pwd) throws SQLException {
        return ud.updSec(name,pwd);
    }
}
