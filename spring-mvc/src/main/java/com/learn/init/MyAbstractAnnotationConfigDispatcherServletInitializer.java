package com.learn.init;

import com.learn.config.SpringMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 提供SpringMVC容器的核心配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("MyAbstractAnnotationConfigDispatcherServletInitializer >>> getServletConfigClasses");
        return new Class[]{SpringMvcConfig.class};
    }

    //提供前端控制器的映射路径
    @Override
    protected String[] getServletMappings() {
        System.out.println("MyAbstractAnnotationConfigDispatcherServletInitializer >>> getServletMappings");
        return new String[]{"/"};
    }
}
