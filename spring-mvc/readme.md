# Spring MVC
- 请求路径的配置
- 请求数据的接收
- JavaWeb常用对象获取
- 静态资源的请求
- 注解驱动<mvc:annotation-driven>标签

## RequestMapperHandlerMapping
用于处理请求映射并将请求分发到相应的处理程序（Controller）方法上,并提供相应的适配器来执行处理程序方法。它是 Spring MVC 框架中请求处理的关键组件之一，用于实现控制器的路由和请求处理。
作用: 请求映射、URL匹配策略、生成请求处理器映射、处理器方法的处理器适配。

# DispatchServlet
**作用:**

# Interceptor 
执行顺序: 
MyInterceptor1 >>> preHandle >>> true
MyInterceptor2 >>> preHandle >>> true
param1 >>> 
MyInterceptor2 >>> postHandle >>> 
MyInterceptor1 >>> postHandle >>> 
MyInterceptor2 >>> afterCompletion >>> 
MyInterceptor1 >>> afterCompletion >>> 

# 配置处理

## xml配置
> spring整合mvc，将bean的管理注入到mvc容器中。涉及：请求、响应、拦截、静态资源、上传文件处理。
- 配置请求
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <context:component-scan base-package="com.learn.controller"/>

    <!--配置请求处理器-->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>

    <!--配置响应转化处理器, 结果返回JSON等操作-->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
        <property name="messageConverters">
            <list>
                <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
            </list>
        </property>
    </bean>

    <!--配置文件上传解析器-->
    <!--    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">-->
    <!--        <property name="defaultEncoding" value="UTF-8"/>-->
    <!--        <property name="maxUploadSize" value="5000000"/>-->
    <!--    </bean>-->

    <!--向容器中注册静态资源处理器-->
    <!-- http://localhost:8080/spring-mvc/img/heima.jpg -->
    <!--    <mvc:resources mapping="/img/*" location="/img/"/>-->
    <mvc:default-servlet-handler/>


    <!-- 配置拦截器 >>> interceptor -->
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.learn.interceptor.MyInterceptor1"/>
        </mvc:interceptor>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.learn.interceptor.MyInterceptor2"/>
        </mvc:interceptor>
    </mvc:interceptors>
</beans>
```

## xml整合请求和响应
> 通过配置 <mvc:annotation-driven/> 驱动处理。默认会进行注册 RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter


## 全注解配置
```java
@Configuration
@ComponentScan("com.learn")
@EnableWebMvc
public class SpringMvcConfig {
    // 文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(5000000);
        return multipartResolver;
    }
}
```

- 配置容器启动加载
```java
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
```

## 总结
1. 容器启动监听加载指定配置，要么就是web.xml配置启动，要么就是继承某个类，实现内部某个方法
2. 配置请求、响应、拦截器、静态资源、上传文件解析等Bean进行处理