package com.learn.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean后处理器 >>> 主要是对Bean对象的操作、存储到singleObjectMap中，再对Bean对象进行修改。
 * @author lints
 * @Date 2023/7/1
 * @Descirption 更多的是对项目中的Bean做操作，每一个Bean都会获取执行。
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("对Bean对象的前置操作，修改或设置Bean属性 >>> beanName = " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("对Bean对象的后置操作，修改或设置Bean属性 >>> beanName = " + beanName);
        // 可以获取Bean，通过反射，实现AOP的切面效果。
        return bean;
    }
}
