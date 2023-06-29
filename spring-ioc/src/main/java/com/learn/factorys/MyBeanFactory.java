package com.learn.factorys;

import com.learn.service.IUserService;
import com.learn.service.impl.UserServiceImpl;

/**
 * 使用BeanFactory来创建Bean对象
 */
public class MyBeanFactory {

    /**
     *     <bean id="myBeanFactory1" class="com.learn.factorys.MyBeanFactory"/>
     *
     *     <bean id="userServiceFactory" factory-bean="myBeanFactory1" factory-method="getUserService">
     *         <constructor-arg name="userName" value="zhangsan"/>
     *     </bean>
     *     主要配置这里，通过声明Bean，然后表示该Bean的创建是通过BeanFactory，调用方法是getUserService
     * @param userName
     * @return
     */
    public IUserService getUserService(String userName) {
        System.out.println("MyBeanFactory >>> getUserService >>> 通过BeanFactory创建对象");
        return new UserServiceImpl();
    }

    /**
     *    <bean id="myBeanFactory" class="com.learn.factorys.MyBeanFactory" factory-method="getUserServiceToStatic">
     *         <constructor-arg name="userName" value="zhangsan"/>
     *     </bean>
     *
     *     同上，只是这里表示的是静态方法，也是一个意思。
     * @param userName
     * @return
     */
    public static IUserService getUserServiceToStatic(String userName) {
        System.out.println("MyBeanFactory >>> getUserServiceToStatic >>> 通过BeanFactory创建对象");
        return new UserServiceImpl();
    }

}
