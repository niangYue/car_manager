package com.ch.car.car_manager.service.impl;

import com.ch.car.car_manager.pojo.CUser;
import com.ch.car.car_manager.mapper.CUserMapper;
import com.ch.car.car_manager.service.CUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2023-09-28
 */
@Service
public class CUserServiceImpl extends ServiceImpl<CUserMapper, CUser> implements CUserService {

    @Autowired
    private CUserMapper cUserMapper;

    public int signup(CUser cUser) {
        cUser.setUserId((int)(Math.random() * 1000000));
        int insert = 0;
        try {
            insert = cUserMapper.insert(cUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }
}
