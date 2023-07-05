package com.learn.config;

import com.learn.beans.OtherBean;
import com.learn.imports.MyImportBeanDefinitionRegistrar;
import com.learn.imports.MyImportSelector;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lints
 * @Date 2023/7/5
 * @Descirption
 */
@Configuration
// 对应xml配置 => <context:component-scan base-package="com.learn"/>
@ComponentScan("com.learn")
// 对应xml配置 => <context:property-placeholder location="jdbc.properties"/>
@PropertySource("jdbc.properties")
// 对应xml配置 => <import resource=""></import>
// @Import({OtherBean.class, MyImportBeanDefinitionRegistrar.class})
@Import(MyImportSelector.class)

// 对应xml配置，扫描Mapper文件
//    <mappers>
//        <package name="com.itheima.mapper"></package>
//    </mappers>
// @MapperScan("com.learn.mapper")
public class SpringConfig {


}
