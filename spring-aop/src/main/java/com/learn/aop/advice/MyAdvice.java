package com.learn.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author lints
 * @Date 2023/6/23
 * @Descirption 代理对象: 目标方法进行增强后的对象。客户端实际调用的对象。
 */
public class MyAdvice {

    public void before(JoinPoint joinPoint) {
        System.out.println("前置增强..." + "目标对象 >>> " + joinPoint.getTarget() + " 表达式 >>> " + joinPoint.getStaticPart());
    }

    public void afterThrowing(Throwable e) {
        System.out.println("异常信息抛出");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始...");
        // 执行目标方法处理
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕通知结束...");
    }

    public void after() {
        System.out.println("最终增强...");
    }

    /**
     * 结果:
     * 前置增强...目标对象 >>> com.learn.aop.service.impl.UserServiceImpl@56de5251 表达式 >>> execution(void com.learn.aop.service.IUserService.show())
     * 环绕通知开始...
     * show.......
     * 最终增强...
     * 环绕通知结束...
     * 后置增强...
     */

}
