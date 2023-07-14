package com.learn.service.impl;

import com.learn.mapper.UserMapper;
import com.learn.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void opt() {
        userMapper.decrMoney("zhangsan", 500);
        int i = 1/0;
        userMapper.incrMoney("lisi", 500);
        System.out.println("转账成功");
    }

}
