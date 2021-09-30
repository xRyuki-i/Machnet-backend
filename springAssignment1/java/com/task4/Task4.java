package com.task4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task4 {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        Student student4=ctx.getBean("student4",Student.class);
        student4.test();
        System.out.println(student4);
    }
}
