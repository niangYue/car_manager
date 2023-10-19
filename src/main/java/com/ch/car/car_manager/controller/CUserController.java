package com.ch.car.car_manager.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.car.car_manager.pojo.CUser;
import com.ch.car.car_manager.service.impl.CUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Currency;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chen
 * @since 2023-09-28
 */
@Slf4j
@Controller
public class CUserController {
    @Autowired
    private CUserServiceImpl userService;

    @RequestMapping("/")
    public String index() {
        return "signin";
    }

    @RequestMapping("/signin")
    public String signin(String cName, String cPwd, HttpSession session, Model modle) {
        QueryWrapper<CUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", cName);
        queryWrapper.eq("user_pwd", cPwd);

        List<CUser> list = userService.list(queryWrapper);

        if (list.isEmpty()){
            modle.addAttribute("error","用户名或密码错误！");
            return "signin";
        }else if(list.get(0).getUserGrade() == 0){
            modle.addAttribute("error","用户没有管理员权限！");
            return "signin";
        }else {
            log.info("查询到要登录的用户" + list.get(0).getUserName());
            session.setAttribute("cuser",list.get(0));
            return "index";
        }
    }

    @RequestMapping("/signup")
    public String signup(CUser cUser,Model model){
        int i = userService.signup(cUser);
        if (i > 0)
        return "signin";
        else {
            model.addAttribute("error","注册失败！");
            return "forward:/toPage/signup";
        }
    }

    @RequestMapping("/carManger")
    public String carManger(Model model){
        List<CUser> list = userService.list();
        model.addAttribute("cusers",list);
        return "carManger";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String userId){
        if (userId == null){
            return "redirect:/carManger";
        }
        QueryWrapper<CUser> cUserQueryWrapper = new QueryWrapper<>();
        cUserQueryWrapper.eq("user_id",userId);
        boolean b = userService.remove(cUserQueryWrapper);
        return "redirect:/carManger";
    }

    @RequestMapping("/selectUser")
    public String selectUserBuId(String userId,Model model){
        if (userId == null){
            return "redirect:/carManger";
        }
        List<CUser> users = userService.list(new QueryWrapper<CUser>().eq("user_id", userId));
        for (CUser user : users) {
            if (user != null){
                model.addAttribute("user",user);
            }else {
                break;
            }
        }
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(CUser cUser){
        //可以做数据校验
        boolean user_id = userService.update(cUser, new QueryWrapper<CUser>().eq("user_id", cUser.getUserId()));
        return "redirect:/carManger";
    }
}

