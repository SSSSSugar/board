package cn.dao;

import cn.bean.user;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:10
 */
public interface adminDao {
    /**
     * 管理员删除用户
     * @param name
     */
    boolean delUser(String name) throws SQLException;

    /**
     * 查询所有信息
     * @return
     * @throws SQLException
     */
    List<user> queryUser() throws SQLException;
}
