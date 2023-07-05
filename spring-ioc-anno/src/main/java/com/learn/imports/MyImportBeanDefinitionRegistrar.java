package com.learn.imports;

import com.learn.beans.RegisteryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lints
 * @Date 2023/7/5
 * @Descirption
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    // 注册BeanDefinition到BeanDefinitionMap中
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(RegisteryBean.class.getName());
        registry.registerBeanDefinition("registeryBean", beanDefinition);

    }
}
