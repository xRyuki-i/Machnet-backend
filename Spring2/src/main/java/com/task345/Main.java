package com.task345;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config345.class);
        Student student = context.getBean(Student.class);
        student.displayStudentInfo();
    }
}
