package cn.service.impl;

import cn.bean.user;
import cn.dao.adminDao;
import cn.dao.impl.adminDaoImpl;
import cn.service.adminService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:12
 */
public class adminServiceImpl implements adminService {
    adminDao ad = new adminDaoImpl();
    @Override
    public boolean delUser(String name) throws SQLException {
        return ad.delUser(name);
    }

    @Override
    public List<user> queryUser() throws SQLException {
        return ad.queryUser();
    }
}
