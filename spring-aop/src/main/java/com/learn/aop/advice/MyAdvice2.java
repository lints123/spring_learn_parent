package com.learn.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lints
 * @Date 2023/6/23
 * @Descirption
 * xml配置加接口的方式
 * 前置通知、后置通知、环绕通知、如果配置在同一个类的情况，那么前置后置不会打印信息
 */
public class MyAdvice2 implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAdvice2 >>> 前置增强.....");
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAdvice2 >>> 后置增强.....");
    }


    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MyAdvice2 >>> 环绕通知开始.....");
        Object res = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
        System.out.println("MyAdvice2 >>> 环绕通知结束.....");
        return res;
    }
}
