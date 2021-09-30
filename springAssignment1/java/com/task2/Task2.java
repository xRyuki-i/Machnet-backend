package com.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task2 {
    public static void main(String[] args) {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("beans.xml");
        Student student2= (Student) ctx.getBean("student2");
        Address address= (Address) ctx.getBean("address1");

        System.out.println(student2);
        System.out.println(address);
    }
}
