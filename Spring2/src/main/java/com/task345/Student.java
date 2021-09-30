package com.task345;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class Student {
    @Value("${student.student_id}")
    private int studentId;

    @Value("${student.student_name}")
    private String studentName;

    @Value("${student.company}")
    private String company;

    @Autowired
    private Address address;

    @Autowired
    @Qualifier("javaScriptProgramming")
    private Programming programming;

    public void displayStudentInfo() {
        System.out.println("Student Id: " + studentId);
        System.out.println("Student Name: " + studentName);
        address.displayAddressInfo();
        programming.programming();
    }
}
