package org.drogo.basics.streams.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        /* 1. List all distinct project in non-ascending order. */
        List<String> projectList = employeeList.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(p -> p.getName())
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        System.out.println(projectList);

        /* 2. Print full name of any employee whose firstName starts with ‘A’.*/
        employeeList.stream()
                .filter(e -> e.getFirstName().toLowerCase().startsWith("a"))
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .forEach(System.out::println);

        /* 3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters) */
        List<Employee> emp2023 = employeeList.stream()
                .filter(employee -> employee.getId().startsWith("2023"))
                .toList();
        System.out.println(emp2023);

        /* 4. Sort employees based on firstName, for same firstName sort by salary.*/
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparingInt(Employee::getSalary))
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getSalary()));

        /* 5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary). */
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(2)
                .findFirst().ifPresent(employee -> System.out.println(employee.getFirstName()));

        /* 6. Print min salary.*/
        employeeList.stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .ifPresent(employee -> System.out.println(employee.getSalary()));

        /* 7. Print list of all employee with min salary.*/
        List<Employee> empListWithMinSalary = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .stream().toList();
        System.out.println(empListWithMinSalary);

        /* 8. List of people working on more than 2 projects.*/
        List<Employee> empWithMoreThanTwoProjects = employeeList.stream()
                .filter(employee -> employee.getProjects().size() > 2)
                .toList();

        System.out.println(empWithMoreThanTwoProjects);

        /*  9. Count of total laptops assigned to the employees. */
        Integer totalLaptops = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .reduce(0, Integer::sum);

        System.out.println(totalLaptops);

        /*  10. Count of all projects with Robert Downey Jr as PM.*/
        long robertDowneyJrCount = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .count();
        System.out.println(robertDowneyJrCount);

        /*  11. List of all projects with Robert Downey Jr as PM. */
        List<Project> robertDowneyJrProjects = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .toList();

        System.out.println(robertDowneyJrProjects);

        /*  12. List of all people working with Robert Downey Jr.*/
        List<String> workingWithRDJ = employeeList.stream()
                .filter(employee -> employee.getProjects().stream().anyMatch(project -> project.getProjectManager().equals("Robert Downey Jr")))
                .map(Employee::getFirstName)
                .toList();

        System.out.println(workingWithRDJ);


        /*
            13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
            14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.*/
    }
}
