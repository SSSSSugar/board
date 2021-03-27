package cn.dao.impl;

import cn.bean.note;
import cn.bean.pwdnote;
import cn.bean.user;
import cn.dao.userDao;
import cn.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:11
 */
public class userDaoImpl implements userDao {

    @Override
    public boolean addNote(note note) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into note(note,username,time) values (?,?,?)";
        int num = queryRunner.update(sql,new Object[]{note.getNote(),note.getUsername(),note.getTime()});
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public boolean delNote(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from note where noteid = ?";
        int num = queryRunner.update(sql,id);
        if (num > 0)
            return true;
        return false;
    }

    @Override
    public boolean updNote(note note) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update note set note = ?,username = ?,time = ? where noteid = ?";
        int num = queryRunner.update(sql,new Object[]{note.getNote(),note.getUsername(),note.getTime(),note.getNoteid()});
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public List<note> queryNote(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from note where username = ?";
        List<note> list = (List) queryRunner.query(sql,new BeanListHandler(note.class),username);

        return list;
    }

    @Override
    public boolean checkSecpwd(String username,String secpwd) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user where username = ? and secpwd = ?";
        user u = (user) queryRunner.query(sql,new BeanHandler(user.class),new Object[]{username,secpwd});
        if (u!=null)
            return true;

        return false;
    }

    @Override
    public boolean addPwd(pwdnote pwdnote) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into pwdnote(pwdnote,username,time) values (?,?,?)";
        int num = queryRunner.update(sql,new Object[]{pwdnote.getPwdnote(),pwdnote.getUsername(),pwdnote.getTime()});
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public boolean delPwd(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from pwdnote where pwdnoteid = ?";
        int num = queryRunner.update(sql,id);
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public boolean updPwd(pwdnote pwdnote) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update pwdnote set pwdnote = ?,username = ?,time = ? where pwdnoteid = ?";
        int num = queryRunner.update(sql,new Object[]{pwdnote.getPwdnote(),pwdnote.getUsername(),pwdnote.getTime(),pwdnote.getPwdnoteid()});
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public List<pwdnote> queryPwdnote(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from pwdnote where username = ?";
        List list = (List) queryRunner.query(sql,new BeanListHandler(pwdnote.class),username);

        return list;
    }

    @Override
    public boolean updSec(String username, String pwd) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update user set secpwd = ? where username = ?";
        int num = queryRunner.update(sql,new Object[]{pwd,username});
        if (num > 0)
            return true;

        return false;
    }

    @Override
    public note queryNoteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from note where noteid = ?";
        note note = (cn.bean.note) queryRunner.query(sql, new BeanHandler(cn.bean.note.class),id);
        return note;
    }

    @Override
    public pwdnote queryPwdnoteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from pwdnote where pwdnoteid = ?";
        pwdnote note = (pwdnote) queryRunner.query(sql, new BeanHandler(pwdnote.class),id);
        return note;
    }


}
