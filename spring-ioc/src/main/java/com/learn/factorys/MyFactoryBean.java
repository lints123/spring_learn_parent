package com.learn.factorys;

import com.learn.service.IUserService;
import com.learn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lints
 * @Date 2023/6/29
 * @Descirption  实现FactoryBean的接口，只要声明了，spring会默认调用getObject方法，创建Bean
 */
public class MyFactoryBean implements FactoryBean<IUserService> {

    public IUserService getObject() throws Exception {
        System.out.println("MyFactoryBean >>> getObject >>> 通过FactoryBean创建对象");
        return new UserServiceImpl();
    }

    public Class<?> getObjectType() {
        return IUserService.class;
    }
}
