package xyz.yiui.dao;

import jdk.jfr.Name;
import org.apache.ibatis.annotations.*;
import xyz.yiui.pojo.Torder;

import java.util.List;

@Mapper
public interface TorderDao {
    /********************查找所有订单*****************************************************/
     @Select("select * from torder")
     List<Torder> FindAll();
    /********************插入订单************************************************/
    @Insert("insert into torder(order_id,car_id,user_idcard,daytime)" + "values(#{order_id},#{car_id},#{user_idcard},#{daytime})")
    int InsertOrder(Torder order);
    /********************根据ID查询订单************************************************/
    @Select("select * from torder where order_id=#{pos}")
    @Results({
        @Result(property = "now_user",column = "user_idcard",
            one=@One(select = "xyz.yiui.dao.userDao.FindByIdCard")
        ),
        @Result(property = "now_car",column = "car_id",
            one=@One(select = "xyz.yiui.dao.CarDao.FindById")
        )
    })
    Torder FindById(int pos);
    /********************根据车次查询订单************************************************/
    @Select("select * from torder where car_id=#{pos}")
    List<Torder> FindByCarid(String pos);
    /********************根据身份证号查询订单************************************************/
    @Select("select * from torder where user_idcard=#{pos}")
    List<Torder> FindByUserIdcard(String pos);
    /********************根据ID删除订单************************************************/
    @Delete("delete from torder where order_id=#{pos}")
    int DeleteById(int pos);
}
