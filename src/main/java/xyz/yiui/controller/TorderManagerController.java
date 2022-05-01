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
public class TorderManagerController {
    @Autowired
    private TorderDao orderdao;
    /**********************************订单管理***********************************************************/
    @GetMapping("order_mana")
    public String OrderMana(Model model){
        List<Torder>lsto=orderdao.FindAll();
        model.addAttribute("odrArr",lsto);
        return "OrderManager";
    }
    @PostMapping("order_find_by_orderid")
    public String OrderFindByOrderid(@RequestParam("seach_order_id")int id,Model model){
        Torder tt = orderdao.FindById(id);
        model.addAttribute("details_order", tt);
        return "OrderDetails";
    }
    @PostMapping("order_find_by_carid")
    public String OrderFindByCarid(@RequestParam("seach_order_car_id")String id,Model model){
        List<Torder>lsto=orderdao.FindByCarid(id);
        model.addAttribute("odrArr",lsto);
         return "OrderManager";
    }
    @PostMapping("order_find_by_user_idcard")
    public String OrderFindByIdcard(@RequestParam("seach_order_user_idcard")String id,Model model){
        List<Torder>lsto=orderdao.FindByUserIdcard(id);
        model.addAttribute("odrArr",lsto);
         return "OrderManager";
    }
    @GetMapping("/order_del{id}")
    public String DelUser(@PathVariable("id")int id){
        orderdao.DeleteById(id);
        return "redirect:/order_mana";
    }
}
