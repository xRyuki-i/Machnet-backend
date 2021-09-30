package com.task345;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.task345")
@PropertySource("classpath:application.properties")
public class Config345 {

}
