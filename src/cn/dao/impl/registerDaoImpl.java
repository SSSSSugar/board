package cn.dao.impl;

import cn.bean.user;
import cn.dao.registerDao;
import cn.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-29-22:48
 */
public class registerDaoImpl implements registerDao {
    @Override
    public boolean register(user user) throws SQLException {
        boolean flag = false;
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into user (username,password,secpwd,realname,email) values (?,?,?,?,?)";
        int num = queryRunner.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getSecpwd(),user.getRealname(),user.getEmail()});
        if(num > 0)
            flag = true;

        return flag;
    }
}
