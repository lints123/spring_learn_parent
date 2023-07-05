package com.learn.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author lints
 * @Date 2023/7/5
 * @Descirption
 */
@Component
public class OtherBean {

    @Bean
    public DataSource dataSource(
            @Value("jdbc.driver") String driverClassName) {
        System.out.println("OtherBean >>> "+driverClassName);
        return null;
    }

}
