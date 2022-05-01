package xyz.yiui.dao;

import org.apache.ibatis.annotations.*;
import xyz.yiui.pojo.Car;

import java.util.List;
/*
*   private int car_id;
    private String end_station;
    private String start_station;
    private float money;
    private String start_time;
    private String end_time;
* */
@Mapper
public interface CarDao {
    /********************查找所有车次*****************************************************/
     @Select("select * from car")
     List<Car> FindAll();
    /********************插入车次************************************************/
    @Insert("insert into car(car_id,end_station,start_station,money,start_time,end_time)" + "values(#{car_id},#{end_station},#{start_station},#{money},#{start_time},#{end_time})")
    int InsertCar(Car car);
    /********************根据ID删除车次************************************************/
    @Delete("delete from car where car_id=#{car_id}")
    int DeleteById(String car_id);
    /********************根据ID查找车次************************************************/
    @Select("select * from car where car_id=#{car_id}")
    Car FindById(String car_id);
    /********************更新车次************************************************/
    /*
    *  @Update("update users set uname=#{uname},uage=#{uage}" + " where uid = #{uid}")
    int UpdateUser(User user);
    * */
    @Update("update car set end_station=#{end_station},start_station=#{start_station},money=#{money},start_time=#{start_time},end_time=#{end_time} where car_id=#{car_id}")
    int Update(Car car);
    @Select("select * from car where start_station=#{start_station} and end_station=#{end_station}")
    List<Car> FindGotoCar(String start_station,String end_station);
}
