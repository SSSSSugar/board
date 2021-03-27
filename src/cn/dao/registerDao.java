package cn.dao;

import cn.bean.user;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-29-22:47
 */
public interface registerDao {
    /**
     * 注册
     * @param user
     * @return
     */
    boolean register(user user) throws SQLException;
}
