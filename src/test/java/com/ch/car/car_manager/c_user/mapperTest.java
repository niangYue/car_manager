package com.ch.car.car_manager.c_user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.car.car_manager.mapper.CUserMapper;
import com.ch.car.car_manager.pojo.CUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 陈辉
 * @Date: 2023/09/28/14:42
 * @Description:
 * @version: 1.0
 */
@SpringBootTest
public class mapperTest {

    @Autowired
    private CUserMapper mapper;

    @Test
    public void test1(){
        QueryWrapper<CUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name","tom");
        queryWrapper.eq("user_pwd","454555");

        List<CUser> users = mapper.selectList(queryWrapper);

//        List<CUser> users = mapper.selectList(null);

        System.out.println(users);
    }

    @Test
    public void test2(){
        UUID x = UUID.randomUUID();
        System.out.println(x.toString().substring(0,6));

    }

}
