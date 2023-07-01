package com.learn.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean工厂后处理器，只会执行一次
 * @author lints
 * @Date 2023/7/1
 * @Descirption   实现该类，主要是类填充到BeanDefinitionMap后，再添加一些新的类进去。
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("实现 BeanFactoryPostProcessor >>> beanDefinitionMap填充完毕后回调该方法");

        // 注册IPersonService
//        BeanDefinition beanDefinition = new RootBeanDefinition();
//        beanDefinition.setBeanClassName("com.learn.service.impl.PersonServiceImpl");
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
//        defaultListableBeanFactory.registerBeanDefinition("personService", beanDefinition);


    }
}
