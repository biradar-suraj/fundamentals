package org.drogo.basics.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {

    static List<Employee> employees= new ArrayList<>();
    static {
        employees.add(
                new Employee("Suraj","Biradar",8000.0,List.of("Project1","Project2"))
        );
        employees.add(
                new Employee("Ramki","N",9000.0,List.of("Project2","Project3"))
        );
        employees.add(
                new Employee("Vinayaka","Hebbar",5000.0,List.of("Project2","Project4"))
        );


    }

    public static void main(String[] args) {

        //forEach
        employees.forEach(System.out::println);

        //map
        List<Employee> incrementedSalaryLisr1=employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(), employee.getLastName(), employee.getSalary()*1.10,employee.getProjects()))
                .toList();

        System.out.println(incrementedSalaryLisr1);

        //filter
        List<Employee> incrementedSalaryList2 = employees.stream()
                .filter(employee -> employee.getSalary() > 5000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(), employee.getLastName(), employee.getSalary() * 1.10, employee.getProjects()))
                .toList();

        System.out.println(incrementedSalaryList2);

        //find first
        Employee first = employees.stream()
                .filter(employee -> employee.getSalary() > 5000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(), employee.getLastName(), employee.getSalary() * 1.10, employee.getProjects()))
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

    }
}
