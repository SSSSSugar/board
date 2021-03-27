package cn.service.impl;

import cn.bean.admin;
import cn.bean.user;
import cn.dao.impl.loginDaoImpl;
import cn.dao.loginDao;
import cn.service.loginService;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-30-16:04
 */
public class loginServiceImpl implements loginService {

    loginDao ld = new loginDaoImpl();
    @Override
    public admin checkAdminLogin(String name, String pwd) throws SQLException {
        return ld.checkAdminLogin(name, pwd);
    }

    @Override
    public user checkUserLogin(String name, String pwd) throws SQLException {
        return ld.checkUserLogin(name, pwd);
    }
}
