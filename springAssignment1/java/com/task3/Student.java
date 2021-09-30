package com.task3;

public class Student {
    private int studentId;
    private String studentName;
    private  Address address;

    public Student(int studentId, String studentName, Address address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", address=" + address +
                '}';
    }
}