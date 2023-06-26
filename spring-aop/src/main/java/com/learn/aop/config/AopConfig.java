package com.learn.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lints
 * @Date 2023/6/23
 * @Descirption
 */
@ComponentScan("com.learn")   //<context:component-scan base-package="com.itheima"/>  注解方式下，扫描指定包
@EnableAspectJAutoProxy      // //<aop:aspectj-autoproxy/>  开始 AOP 配置
@Configuration
public class AopConfig {
}
