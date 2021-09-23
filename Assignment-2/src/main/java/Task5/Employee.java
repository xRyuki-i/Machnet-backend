package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee {
    String name;
    Integer age;
    String department;
    Integer salary;

    enum DepartmentType {
        Sports,
        Art,
        Dev
    }

    public Employee(String name, Integer age, String department, Integer salary){
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment(){
        return this.department;
    }

    public Integer getSalary(){
        return this.salary;
    }

    public static void main (String[] args){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Nischal", 20, "Sports", 500));
        employees.add(new Employee("Ruby", 18, "Arts", 400));
        employees.add(new Employee("Ajay", 22, "Sports", 500));
        employees.add(new Employee("Hector", 25, "Arts", 700));
        employees.add(new Employee("Vivek", 23, "Arts", 450));
        employees.add(new Employee("Asuna", 18, "Dev", 350));

        //Task 5 question 1
        List<Integer> salary = employees.stream()
                .map(e ->  e.salary)
                .collect(Collectors.toList());

        Integer totalSalary = salary.stream()
                .reduce(0,(acc, e)-> acc + e);

        Integer avgSalary = totalSalary/salary.size();

        //Task 5 question 2
        Set<String> uniqueDepartment = employees.stream()
                .map(e ->  e.department)
                .collect(Collectors.toSet());

        //Task 5 question 3
        Map<String, Double> departments = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));

        System.out.println("The average salary of employees is "+ avgSalary);
        System.out.println("The unique departments are"+ uniqueDepartment);
        System.out.println(departments);
    }
}
