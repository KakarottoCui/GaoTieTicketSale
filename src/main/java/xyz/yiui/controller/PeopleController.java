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
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PeopleController {
    @Autowired
    private CarDao cardao;
    @Autowired
    private userDao userdao;
    @Autowired
    private TorderDao torderdao;
    @PostMapping("find_car")
    public String FindCar(
            @RequestParam("leave_city") String leave_city,
            @RequestParam("arrive_city") String arrive_city,
            @RequestParam("leave_date")String dd,
            Model model,HttpSession session
    ){
        System.out.println(dd);
        List<Car> destination;
        destination = new ArrayList<>();
        destination = cardao.FindGotoCar(leave_city,arrive_city);
        model.addAttribute("destination",destination);
        session.setAttribute("leave_date",dd);
        return "TrainDetails";///跳转车次详情页面
    }
    @GetMapping("/buy_car{car_id}")
    public String BuyCar(
            @PathVariable("car_id")String car_id, HttpSession session,Model model
    ){
//        user 购买了这个车票
//        订单里这个人买了这个票
        String userid= String.valueOf(session.getAttribute("id"));
        System.out.println(userid+"购买了"+car_id);
        user uu=userdao.FindById(userid);
        session.setAttribute("buy_user",uu);
        Car cc=cardao.FindById(car_id);
        session.setAttribute("buy_car",cc);
        return "OrderBuy";
    }
    @GetMapping("/myorder")
    public String GoMyOrder(Model model,HttpSession session){
        int nowid= (int) session.getAttribute("id");
        user now_user=userdao.FindById(String.valueOf(nowid));
        List<Torder>lst=torderdao.FindByUserIdcard(now_user.getIdcard());
        model.addAttribute("myodrArr",lst);
        return "MyOrder";
    }
    @PostMapping("order_zhifu")
    public String Zhifu(Model model,HttpSession session){
        user now_user= (user) session.getAttribute("buy_user");
        Car now_car=(Car) session.getAttribute("buy_car");
        String dd=(String) session.getAttribute("leave_date");
        Torder now_order=new Torder(now_car.getCar_id(),now_user.getIdcard(),dd);
        torderdao.InsertOrder(now_order);
        List<Torder>lst=torderdao.FindByUserIdcard(now_user.getIdcard());
        model.addAttribute("myodrArr",lst);
        return "MyOrder";
    }
    @GetMapping("/my_order_del{id}")
    public String DelMyOrder(@PathVariable("id")int order_id){
        torderdao.DeleteById(order_id);
        return "redirect:/myorder";
    }
}
