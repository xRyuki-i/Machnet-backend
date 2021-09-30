package com.task1;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }
}
