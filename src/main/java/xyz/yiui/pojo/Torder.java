package xyz.yiui.pojo;

public class Torder {
    private int order_id;
    private String car_id;
    private String user_idcard;
    private String daytime;
    private Car now_car;
    private user now_user;

    public Car getNow_car() {
        return now_car;
    }

    public void setNow_car(Car now_car) {
        this.now_car = now_car;
    }

    public user getNow_user() {
        return now_user;
    }

    public void setNow_user(user now_user) {
        this.now_user = now_user;
    }

    public Torder(String car_id, String user_idcard, String daytime) {
        this.car_id = car_id;
        this.user_idcard = user_idcard;
        this.daytime=daytime;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getUser_idcard() {
        return user_idcard;
    }

    public void setUser_idcard(String user_idcard) {
        this.user_idcard = user_idcard;
    }

    @Override
    public String toString() {
        return "Torder{" +
                "order_id=" + order_id +
                ", car_id='" + car_id + '\'' +
                ", user_idcard='" + user_idcard + '\'' +
                ", daytime='" + daytime + '\'' +
                ", now_car=" + now_car +
                ", now_user=" + now_user +
                '}';
    }
}
