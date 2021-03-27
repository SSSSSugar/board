package cn.service;

import cn.bean.note;
import cn.bean.pwdnote;
import cn.dao.impl.userDaoImpl;
import cn.dao.userDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sugar
 * @create 2020-06-30-16:11
 */
public interface userService {
    /**
     * 添加备忘录
     * @param note
     * @return
     */
    boolean addNote(note note) throws SQLException;

    /**
     * 删除备忘录
     * @param id
     * @return
     */
    boolean delNote(int id) throws SQLException;

    /**
     * 修改备忘录
     * @param note
     * @return
     */
    boolean updNote(note note) throws SQLException;

    /**
     * 查询备忘录
     * @param username
     * @return
     */
    List<note> queryNote(String username) throws SQLException;

    /**
     * 验证二级密码
     * @param secpwd
     * @return
     */
    boolean checkSecpwd(String username,String secpwd) throws SQLException;

    /**
     * 添加密码本
     * @param pwdnote
     * @return
     */
    boolean addPwd(pwdnote pwdnote) throws SQLException;

    /**
     * 删除密码本
     * @param id
     * @return
     */
    boolean delPwd(int id) throws SQLException;

    /**
     * 修改密码本
     * @param pwdnote
     * @return
     */
    boolean updPwd(pwdnote pwdnote) throws SQLException;

    /**
     * 查询密码本
     * @return
     */
    List<pwdnote> queryPwdnote(String username) throws SQLException;

    /**
     * 修改二级密码
     * @param name
     * @param pwd
     * @return
     */
    boolean updSec(String name, String pwd) throws SQLException;

}
