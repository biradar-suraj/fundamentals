package org.drogo.basics.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {

    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(
                new Employee(
                        "Suraj",
                        "Biradar",
                        8000.0,
                        "Dev", List.of("Project1", "Project2"),
                        new Address("123 Main St", "City", "Country")
                )
        );
        employees.add(
                new Employee(
                        "Ramki",
                        "N",
                        9000.0,
                        "QA", List.of("Project2", "Project3"),
                        new Address("456 Elm St", "Town", "Country")
                )
        );
        employees.add(
                new Employee(
                        "Vinayaka",
                        "Hebbar",
                        5000.0,
                        "Infra", List.of("Project2", "Project4"),
                        new Address("789 Oak St", "Village", "Country")
                )
        );


    }

    public static void main(String[] args) {

        //forEach
        employees.forEach(System.out::println);

        //map
        List<Employee> incrementedSalaryList1 = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getDepartment(),
                        employee.getProjects(),
                        employee.getAddress()))
                .toList();

        System.out.println(incrementedSalaryList1);

        //filter
        List<Employee> incrementedSalaryList2 = employees.stream()
                .filter(employee -> employee.getSalary() > 5000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getDepartment(),
                        employee.getProjects(),
                        employee.getAddress()))
                .toList();

        System.out.println(incrementedSalaryList2);

        //find first
        Employee first = employees.stream()
                .filter(employee -> employee.getSalary() > 5000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getDepartment(),
                        employee.getProjects(),
                        employee.getAddress()))
                .findFirst().orElse(null);

        System.out.println(first);


        //flat map
        String projects = employees.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));

        System.out.println(projects);

        //short circuit operations
        List<Employee> shortCircuitList = employees.stream()
                .skip(1)
                .limit(1)
                .toList();

        System.out.println(shortCircuitList);


        //finite data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //sorting
        List<Employee> sortedEmployees = employees.stream()
                .sorted((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .toList();

        System.out.println(sortedEmployees);

        //min or max
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        //reduce
        Double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println(totalSalary);

        Map<String, Double> empMap = employees.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .collect(Collectors.toMap(Employee::getFirstName, Employee::getSalary));

        System.out.println(empMap);

        //get the department with the highest salary
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getDepartment)
                .ifPresent(emp -> System.out.println("Department with highest salary:" + emp));

        //sort the employees list first by name then by salary and then by country
        var sortedList = employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getSalary)
                        .thenComparing(emp -> emp.getAddress().getCountry()))
                .toList();

        sortedList.forEach(System.out::println);


    }
}
