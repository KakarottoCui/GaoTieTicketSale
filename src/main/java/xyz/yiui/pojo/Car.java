package xyz.yiui.pojo;

public class Car {
    private String car_id;
    private String end_station;
    private String start_station;
    private float money;
    private String start_time;
    private String end_time;

    public Car(String car_id, String end_station, String start_station, float money, String start_time, String end_time) {
        this.car_id = car_id;
        this.end_station = end_station;
        this.start_station = start_station;
        this.money = money;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", end_station='" + end_station + '\'' +
                ", start_station='" + start_station + '\'' +
                ", money=" + money +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
