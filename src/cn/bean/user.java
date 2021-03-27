package cn.bean;

/**
 * @author Sugar
 * @create 2020-06-29-18:12
 */
public class user {
    private int id;
    private String username;
    private String password;
    private String secpwd;
    private String realname;
    private String email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecpwd() {
        return secpwd;
    }

    public String getRealname() {
        return realname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecpwd(String secpwd) {
        this.secpwd = secpwd;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
