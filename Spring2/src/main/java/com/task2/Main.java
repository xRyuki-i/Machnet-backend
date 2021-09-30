package com.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class Main {
    public static void main (String[] args){
        ConfigurableApplicationContext ctx = SpringApplication.run(Config2.class);
        Student std1 = ctx.getBean(Student.class);
        Student std2 = ctx.getBean(Student.class);

        if (std1.hashCode() == std2.hashCode()){
            System.out.println("Both the Objects are same.");
        } else {
            System.out.println("The Objects are different.");
        }
    }
}
