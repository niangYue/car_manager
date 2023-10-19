package com.ch.car.car_manager.service;

import com.ch.car.car_manager.pojo.CUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2023-09-28
 */
public interface CUserService extends IService<CUser> {

    int signup(CUser cUser);
}
