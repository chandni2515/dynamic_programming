package Practise.ep_que;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    private static Map<UUID, List<Employee>> cache = new HashMap<>();
    public static void main(String[] args) {
        Employee emp1 = new Employee(UUID.randomUUID(), 25, "Alice", Department.ACCOUNTING,"F",50000);
        Employee emp2 = new Employee(UUID.randomUUID(), 30, "Bob", Department.BILLING,"M",25000);
        Employee emp3 = new Employee(UUID.randomUUID(), 22, "Charlie", Department.ACCOUNTING,"F",40000);
        Employee emp4 = new Employee(UUID.randomUUID(), 20, "Max", Department.PRODUCTION,"F",30000);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3,emp4);


        cache.put(emp1.getId(),Arrays.asList(emp1,emp2,emp3));
        Demo demo=new Demo();
        System.out.println("Employess grouped by department: ");
        Map<Department, List<Employee>> result=demo.getEmployeesGroupByDept(employees);
        result.forEach((key, value) -> {
            System.out.println("Department: " + key);
            value.forEach(employee -> System.out.println(" - " + employee));
        });
        System.out.println("\nEmployees sorted by age: ");
        List<Employee> employeeSortedByAge = demo.getEmployeeSortedByAge(employees);
        employeeSortedByAge.forEach(System.out::println);

        System.out.println("Employee count by gender:  ");
        Map<String,Long> demoList=employees.stream()
                                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


        System.out.println("\nEmployees by gender:");
        Map<String, List<Employee>> empByGenderList = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        empByGenderList.forEach((key, value) -> {
            System.out.println("Gender: " + key);
            value.forEach(emp-> System.out.println(" - " + emp));
        });

        Long res = employees
                .stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1L);

        System.out.println("\nthird highest salary = " + res);

        System.out.println("\nsorted by name:");
        employees
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

    }

    private List<Employee> getEmployeeSortedByAge(List<Employee> employees) {
        return employees
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }

    private Map<Department,List<Employee>> getEmployeesGroupByDept(List<Employee> employees){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
