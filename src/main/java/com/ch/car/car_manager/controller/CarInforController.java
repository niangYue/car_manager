package com.ch.car.car_manager.controller;


import com.ch.car.car_manager.pojo.CarInfor;
import com.ch.car.car_manager.service.impl.CarInforServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chen
 * @since 2023-09-28
 */
@Controller
public class CarInforController {

    @Autowired
    private CarInforServiceImpl carInforService;

    @RequestMapping("/table")
    public String table(Model model){
        List<CarInfor> list = carInforService.list();
        model.addAttribute("cars",list);
        return "table";
    }
}

