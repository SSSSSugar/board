package cn.service;

import cn.bean.user;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-29-22:43
 */
public interface registerService {
    /**
     * 注册
     * @param user
     * @return
     */
    boolean register(user user) throws SQLException;
}
