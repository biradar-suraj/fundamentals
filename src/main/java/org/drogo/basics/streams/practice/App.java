package org.drogo.basics.streams.practice;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        //1.List all distinct project in non-ascending order.
        List<String> projectList = employeeList.stream()
                .flatMap(e -> e.getProjects().stream())
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .map(Project::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(projectList);

        //2. Print full name of any employee whose firstName starts with ‘A’.

        employeeList.stream()
                .filter(e -> e.getFirstName().startsWith("A"))
                .map(e -> e.getFirstName() + e.getLastName())
                .forEach(System.out::println);

        //3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        List<Employee> emp2023 = employeeList.stream()
                .filter(e -> "2023".equals(e.getId().substring(0, 4)))
                .toList();

        System.out.println(emp2023);

        //4. Sort employees based on firstName, for same firstName sort by salary.
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        //5. Print names of all employee with 3rd highest salary.
        Optional<String> thirdHighestSalary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2)
                .map(Employee::getFirstName)
                .findFirst();
        thirdHighestSalary.ifPresent(System.out::println);

        //6. Print min salary.
        OptionalInt minSalary = employeeList.stream()
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .min();
        minSalary.ifPresent(System.out::println);

        //7. Print list of all employee with min salary.
        Optional<Integer> employeeWithMinSalary = employeeList.stream()
                .map(Employee::getSalary)
                .min(Integer::compare);

        if (employeeWithMinSalary.isPresent()) {
            List<Employee> employeesWithMinSalary = employeeList.stream()
                    .filter(e -> e.getSalary() == employeeWithMinSalary.get())
                    .toList();
            System.out.println(employeesWithMinSalary);
        }

        //8. List of people working on more than 2 projects.
        List<Employee> epmWithMoreThanTwoProjects = employeeList.stream()
                .filter(e -> e.getProjects().size() > 2)
                .toList();

        //9. Count of total laptops assigned to the employees.
        int totalLaptopCount = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(totalLaptopCount);

        int laptopCount = employeeList.stream()
                .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();
        System.out.println(laptopCount);

        //10. Count of all projects with Robert Downey Jr as PM.
        long empUnderRDJ = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .count();
        System.out.println(empUnderRDJ);

        //11. List of all projects with Robert Downey Jr as PM.
        List<Project> projectsUnderRDJ = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .collect(Collectors.toList());
        System.out.println(projectsUnderRDJ);

        // 12. List of all people working with Robert Downey Jr.
        List<Employee> empWithRDJ = employeeList.stream()
                .filter(employee -> employee.getProjects().stream().anyMatch(project -> project.getProjectManager().equals("Robert Downey Jr")))
                .collect(Collectors.toList());

        System.out.println(empWithRDJ);

        //13. Create a map based on this data, the key should be the year of joining, and value should be list of all the employees who joined the particular year.
        Map<String, List<Employee>> resultMap = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4)));

        System.out.println(resultMap);

        //14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
        Map<String, Long> empCountByYear = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4), Collectors.counting()));

        System.out.println(empCountByYear);

    }
}
