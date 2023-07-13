package com.learn.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 整合web，该类主要是将配置文件告诉Spring容器，将web整合到Spring中
 */
public class MyAnnotationConfigApplicationContext extends AnnotationConfigWebApplicationContext {

    public MyAnnotationConfigApplicationContext() {
        super();
        this.register(SpringConfig.class);
    }
}
