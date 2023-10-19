package com.ch.car.car_manager.controller;

import com.ch.car.car_manager.pojo.CUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 陈辉
 * @Date: 2023/09/26/0:30
 * @Description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/toPage")
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page, HttpSession session){
        session.setAttribute("cuser",new CUser());
        return page;
    }
}
