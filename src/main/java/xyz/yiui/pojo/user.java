package xyz.yiui.pojo;

public class user {
    private int id;
    private String uname;
    private String password;
    private String idcard;
    private String type;
    private String phonenum;
    private String name;

    public user(String uname, String password, String idcard, String type,String phonenum,String name) {
        this.uname = uname;
        this.password = password;
        this.idcard = idcard;
        this.phonenum=phonenum;
        this.type = type;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", idcard='" + idcard + '\'' +
                ", type='" + type + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
