package com.learn.imports;

import com.learn.beans.RegisteryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author lints
 * @Date 2023/7/5
 * @Descirption  使用到了@Import注解，类上面的注解的信息。就是SpringConfig的信息
 */
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //参数annotationMetadata叫做注解媒体数组，该对象内部封装是当前使用了@Import注解的类上的其他注解的元信息
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
        String[] basePackages = (String[]) annotationAttributes.get("basePackages");
        System.out.println("MyImportSelector >>> "+basePackages[0]);
        //返回的数组封装是需要被注册到Spring容器中的Bean的全限定名
        return new String[]{RegisteryBean.class.getName()};
    }
}
