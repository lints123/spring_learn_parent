package com.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lints
 * @Date 2023/7/18
 * @Descirption
 */
@Configuration
@ComponentScan("com.learn")
@EnableWebMvc
public class SpringMvcConfig {



}
