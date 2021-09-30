package com.task1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class Main {
    public static void main (String[] args){
        ConfigurableApplicationContext ctx = SpringApplication.run(Configuration.class);
        Calculator calculator = ctx.getBean(Calculator.class);
        System.out.println("The sum is : "+calculator.Add(1,2));
        System.out.println("The difference is : "+calculator.Sub(2,1));
        System.out.println("The product is : "+calculator.Add(2,2));
        System.out.println("The division is : "+calculator.Add(4,2));
    }
}
