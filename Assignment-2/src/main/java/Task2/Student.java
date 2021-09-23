package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Student {
    String name;
    Integer semester;
    Integer age;
    String sex;

    public Student(String name, Integer semester, Integer age, String sex){
        this.name = name;
        this.semester = semester;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", semester=" + semester +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main (String[] args){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student ("Nischal",3, 30, "male"));
        students.add(new Student ("Aishwarya", 4, 32, "female"));
        students.add(new Student ("Ajay", 4, 32, "male"));
        students.add(new Student ("Summit", 3, 30, "male"));
        students.add(new Student ("James", 3, 22, "male"));
        students.add(new Student ("Jasmine", 1, 20, "female"));

        List<Student> filteredStudent = students.stream()
                .filter(e -> e.name.toLowerCase().startsWith("j") && e.semester == 3)
                .collect(Collectors.toList());

        System.out.println(filteredStudent);
    }
}
