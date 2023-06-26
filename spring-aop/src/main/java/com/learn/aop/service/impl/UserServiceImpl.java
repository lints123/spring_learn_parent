package com.learn.aop.service.impl;

import com.learn.aop.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 * @Date 2023/6/23
 * @Descirption  目标对象: 需要被增强的对象
 */
// @Service 针对全注解配置的情况，需要交给IOC容器进行管理，如果是XML配置的话，那么在XML配置<bean>
@Service
public class UserServiceImpl implements IUserService {

    public void show() {
        // 用于异常通知处理
        // int i = 10 / 0;
        System.out.println("show.......");
    }

}
