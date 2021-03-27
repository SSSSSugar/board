package cn.dao.impl;

import cn.bean.user;
import cn.dao.adminDao;
import cn.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:10
 */
public class adminDaoImpl implements adminDao {

    @Override
    public boolean delUser(String name) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from user where username = ?";
        int num = queryRunner.update(sql,name);
        if (num > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<user> queryUser() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user";
        List list = (List) queryRunner.query(sql,new BeanListHandler(user.class));

        return list;
    }
}
