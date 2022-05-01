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
public class CarManagerController {

    @Autowired
    private CarDao cardao;
    /**********************************车次管理***********************************************************/
    @GetMapping("car_mana")
    public String CarMana(Model model){
        List<Car>lscar=cardao.FindAll();
        model.addAttribute("carsArr",lscar);
        return "CarManager";
    }
    /**********************************车次管理--根据ID删除车次***********************************************************/
    @GetMapping("/del_car{id}")
    public String DelCar(@PathVariable("id")String id){
        cardao.DeleteById(id);
        return "redirect:/car_mana";
    }
    /**********************************车次管理--根据ID到达更新车次的页面***********************************************************/
    @GetMapping("/to_update_car{id}")
    public String ToUpdateCar(@PathVariable("id")String id, HttpSession session){
        Car now=cardao.FindById(id);
        session.setAttribute("update_car_pojo",now);
        return "redirect:/car_update";
    }
     /**********************************车次管理--根据ID更新车次后返回查询车次页面**********************************************************/
    @PostMapping("update_car")
     public String UpdateCar(@RequestParam("car_id")String car_id,@RequestParam("start_station")String start_station,
                         @RequestParam("end_station")String end_station,@RequestParam("money")float money,
                         @RequestParam("start_time") String start_time,@RequestParam("end_time")String end_time){
        Car now=new Car(car_id,end_station,start_station,money,start_time,end_time);
        cardao.Update(now);
        return "redirect:/car_mana";
    }
     /**********************************车次管理--新增车次***********************************************************/
    @PostMapping("add_car")
    public String AddCar(@RequestParam("car_id")String car_id,@RequestParam("start_station")String start_station,
                         @RequestParam("end_station")String end_station,@RequestParam("money")float money,
                         @RequestParam("start_time") String start_time,@RequestParam("end_time")String end_time){
        Car now=new Car(car_id,end_station,start_station,money,start_time,end_time);
        cardao.InsertCar(now);
        return "redirect:/car_mana";
    }
    /**********************************搜索车次***********************************************************/
    @PostMapping ("/car_seach")
    public String SeachCar(@RequestParam("seach_car_id")String id,Model model){
        System.out.println("++++"+id);
        List<Car>lss=new ArrayList<>();
        Car now=cardao.FindById(id);
        lss.add(now);
        model.addAttribute("carsArr",lss);
        return "CarManager";
    }
}
