package xyz.yiui.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import xyz.yiui.dao.userDao;
import xyz.yiui.pojo.user;

import javax.sql.DataSource;
import java.util.List;

public class DBUtils {
    @Autowired
    private DataSource druid;

    @Autowired
    private userDao userdao;

    public int InsertUser(user u){
        return userdao.InsertUser(u);
    }

    public user FindUserByName(String p){
        return userdao.FindByName(p);
    }

    public List<user> FindAllUser(){
        return userdao.FindAll();
    }



}
