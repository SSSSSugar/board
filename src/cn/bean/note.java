package cn.bean;

/**
 * @author Sugar
 * @create 2020-06-29-18:03
 */
public class note {
    private int noteid;
    private String note;
    private String username;
    private String  time;

    public int getNoteid() {
        return noteid;
    }

    public String getNote() {
        return note;
    }

    public String getUsername() {
        return username;
    }

    public String getTime() {
        return time;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
