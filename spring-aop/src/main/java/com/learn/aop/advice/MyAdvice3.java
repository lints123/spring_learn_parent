package com.learn.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author lints
 * @Date 2023/6/23
 * @Descirption 注解的方式
 */
@Component
@Aspect
public class MyAdvice3 {

    @Pointcut("execution(* com.learn.aop.service.*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("MyAdvice3 >>> 前置增强...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAdvice3 >>> 后置增强");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("MyAdvice3 >>> 异常");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MyActive3 >>> 环绕增强开始");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("MyActive3 >>> 环绕增强结束");
        return proceed;
    }

    @After("pointCut()")
    public void after() {
        System.out.println("MyAdvice3 >>> 最终增强");
    }

    /**
     * 结果：
     * MyActive3 >>> 环绕增强开始
     * MyAdvice3 >>> 前置增强...
     * show.......
     * MyAdvice3 >>> 后置增强
     * MyAdvice3 >>> 最终增强
     * MyActive3 >>> 环绕增强结束
     */

}
