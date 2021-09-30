package com.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task3 {
    public static void main(String[] args) {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("beans.xml");
        Student student3= (Student) ctx.getBean("student3");
        Address address2= (Address) ctx.getBean("address2");

        System.out.println(student3);
        System.out.println(address2);
    }
}