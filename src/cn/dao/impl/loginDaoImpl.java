package cn.dao.impl;

import cn.bean.admin;
import cn.bean.user;
import cn.dao.loginDao;
import cn.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sound.midi.SoundbankResource;
import java.sql.SQLException;

/**
 * @author Sugar
 * @create 2020-06-30-16:08
 */
public class loginDaoImpl implements loginDao {
    @Override
    public admin checkAdminLogin(String name, String pwd) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from admin where username=? and password=?";
        admin admin = (cn.bean.admin) queryRunner.query(sql,new BeanHandler(admin.class),new Object[]{name,pwd});
        return admin;
    }

    @Override
    public user checkUserLogin(String name, String pwd) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        user user = (cn.bean.user) queryRunner.query(sql,new BeanHandler(user.class),new Object[]{name,pwd});
        return user;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println((new loginDaoImpl().checkAdminLogin("1001","1001")).getUsername());
    }
}
