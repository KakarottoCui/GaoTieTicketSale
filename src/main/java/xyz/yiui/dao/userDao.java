package xyz.yiui.dao;

import org.apache.ibatis.annotations.*;
import xyz.yiui.pojo.user;

import java.util.List;

@Mapper
public interface userDao {
     /********************查找所有用户*****************************************************/
     @Select("select * from users")
     List<user> FindAll();
     /********************根据姓名查找用户*****************************************************/
    @Select("select * from users where uname=#{pos}")
    user FindByName(String pos);
    /********************插入用户************************************************/
    @Insert("insert into users(id,uname,password,idcard,type)" + "values(#{id},#{uname},#{password},#{idcard},#{type})")
    int InsertUser(user user);
    /********************根据ID删除用户************************************************/
    @Delete("delete from users where id=#{id}")
    int DeleteById(String id);
    /********************根据ID查找用户************************************************/
    @Select("select * from users where id=#{id}")
    user FindById(String id);
     /********************更新用户***********************************************/
     @Update("update users set uname=#{uname},password=#{password},idcard=#{idcard} where id=#{id}")
    int Update(user uu);
     /********************模糊用户***********************************************/
     @Select("select * from users where uname like CONCAT('%',#{key},'%');")
     List<user>FindAllByName(String key);
     /********************根据IDCard查找用户************************************************/
    @Select("select * from users where idcard=#{idcard}")
    user FindByIdCard(String idcard);
}
/*
* @Select("select * from book where book_name like CONCAT('%',#{keyWord},'%');")
	public List<Book> findByKeyWord(String keyWord);
* */
/*
* private int id;
    private String uname;
    private String password;
    private String idcard;
    private String type;
* */