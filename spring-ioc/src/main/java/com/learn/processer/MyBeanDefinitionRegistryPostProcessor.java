package com.learn.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean工厂后处理器，只会执行一次
 * @author lints
 * @Date 2023/6/27
 * @Descirption  如果是想要增加额外的Bean到BeanDefinitionMap中，那么实现BeanDefinitionRegisteryPostProcessor，直接注册。
 * 该类的作用：主要是替代BeanDefinitionPostProcessor，简单的注册Bean操作，那边需要强转BeanFactory，这边不用。
 *
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("实现BeanDefinitionRegistryPostProcessor，注册BeanDefinition到BeanDefinitionMap中 >>> 会比BeanDefinitionPostProcess先执行 >>> ");
        // 注册BeanDefinition
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.learn.service.impl.PersonServiceImpl");
        beanDefinitionRegistry.registerBeanDefinition("personService", beanDefinition);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
