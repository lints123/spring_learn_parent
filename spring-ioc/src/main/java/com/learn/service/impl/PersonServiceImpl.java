package com.learn.service.impl;

import com.learn.service.IPersonService;

/**
 * @author lints
 * @Date 2023/7/1
 * @Descirption  该类的定义，通过BeanDefinitionRegistryPostProcessor 创建BeanDefinition。
 */
public class PersonServiceImpl implements IPersonService {
    public void sayPerson() {
        System.out.println("PersonServiceImpl >>> sayPerson >>> ");
    }
}
