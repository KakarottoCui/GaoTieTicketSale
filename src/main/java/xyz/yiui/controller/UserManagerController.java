package xyz.yiui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.yiui.dao.CarDao;
import xyz.yiui.dao.TorderDao;
import xyz.yiui.dao.userDao;
import xyz.yiui.pojo.Car;
import xyz.yiui.pojo.Torder;
import xyz.yiui.pojo.user;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class UserManagerController {
    @Autowired
    private userDao userdao;
    /**********************************用户管理***********************************************************/
    @GetMapping("user_mana")
    public String UserMana(Model model){
        List<user>lst=userdao.FindAll();
        model.addAttribute("usersArr", lst);
        return "UserNameManager";
    }
      /**********************************用户管理--新增用户***********************************************************/
    @PostMapping("add_user")
    public String AddUser(@RequestParam("user_name")String user_name,@RequestParam("user_idcard")String user_idcard,
                         @RequestParam("user_pwd")String user_pwd,@RequestParam("user_type") String user_type,
                          @RequestParam("user_phone")String phone,@RequestParam("user_name")String name){
        user uu=new user(user_name,user_pwd,user_idcard,user_type,phone,name);
        userdao.InsertUser(uu);
        return "redirect:/user_mana";
    }
    /**********************************用户管理--删除用户***********************************************************/
    @GetMapping("/del_user{id}")
    public String DelUser(@PathVariable("id")String id){
        userdao.DeleteById(id);
        return "redirect:/user_mana";
    }
     /**********************************用户管理--根据ID到达更新用户的页面***********************************************************/
    @GetMapping("/to_update_user{id}")
    public String ToUpdateUser(@PathVariable("id")String id, HttpSession session){
        user now=userdao.FindById(id);
        session.setAttribute("update_user_pojo",now);
        return "redirect:/user_update";
    }
    /**********************************用户管理--根据ID更新用户后返回查询用户页面**********************************************************/
    @PostMapping("update_user")
     public String UpdateCar(@RequestParam("user_id")int user_id,@RequestParam("user_name")String user_name,
                         @RequestParam("user_idcard")String user_idcard,@RequestParam("user_pwd")String user_pwd,
                         @RequestParam("user_type") String user_type, @RequestParam("user_phone")String phone,
                         @RequestParam("user_name")String name){
        user now=new user(user_name,user_pwd,user_idcard,user_type,phone,name);
        now.setId(user_id);
        userdao.Update(now);
        return "redirect:/user_mana";
    }
    /**********************************用户管理--根据姓名模糊查询*********************************************************/
    @PostMapping("user_find")
    public String FindUserByName(@RequestParam("seach_user_name")String key,Model model){
        List<user>now=userdao.FindAllByName(key);
        model.addAttribute("usersArr", now);
        return "UserNameManager";
    }

}
