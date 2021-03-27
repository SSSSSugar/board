package cn.bean;

import java.util.Date;

/**
 * @author Sugar
 * @create 2020-06-29-18:13
 */
public class pwdnote {
    private int pwdnoteid;
    private String pwdnote;
    private String username;
    private String time;

    public int getPwdnoteid() {
        return pwdnoteid;
    }

    public String getPwdnote() {
        return pwdnote;
    }

    public String getUsername() {
        return username;
    }

    public String getTime() {
        return time;
    }

    public void setPwdnoteid(int pwdnoteid) {
        this.pwdnoteid = pwdnoteid;
    }

    public void setPwdnote(String pwdnote) {
        this.pwdnote = pwdnote;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
