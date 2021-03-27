package cn.service.impl;

import cn.bean.user;
import cn.dao.impl.registerDaoImpl;
import cn.dao.registerDao;
import cn.service.registerService;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-29-22:45
 */
public class registerServiceImpl implements registerService {
    registerDao rd = new registerDaoImpl();
    @Override
    public boolean register(user user) throws SQLException {
        return rd.register(user);
    }
}
