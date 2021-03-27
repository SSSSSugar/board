package cn.service;

import cn.bean.admin;
import cn.bean.user;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-30-16:00
 */
public interface loginService {
    /**
     * 管理员登录验证
     * @param name
     * @param pwd
     * @return
     */
    admin checkAdminLogin(String name,String pwd) throws SQLException;

    /**
     * 用户登录验证
     * @param name
     * @param pwd
     * @return
     */
    user checkUserLogin(String name,String pwd) throws SQLException;
}
