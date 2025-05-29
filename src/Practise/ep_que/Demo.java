package Practise.ep_que;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    private static Map<UUID, List<Employee>> cache = new HashMap<>();
    public static void main(String[] args) {
        Employee emp1 = new Employee(UUID.randomUUID(), 25, "Alice", Department.ACCOUNTING,"F");
        Employee emp2 = new Employee(UUID.randomUUID(), 30, "Bob", Department.BILLING,"M");
        Employee emp3 = new Employee(UUID.randomUUID(), 22, "Charlie", Department.ACCOUNTING,"F");

        cache.put(emp1.getId(),Arrays.asList(emp1,emp2,emp3));
        Demo demo=new Demo();
        System.out.println("Employess grouped by department: ");
        Map<Department, List<Employee>> result=demo.getEmployeesGroupByDept();
        result.forEach((key, value) -> {
            System.out.println("Department: " + key);
            value.forEach(employee -> System.out.println(" - " + employee));
        });
        System.out.println("Employees sorted by age: "+demo.getEmployeeSortedByAge());

        List<Employee> empList=Arrays.asList(emp1,emp2,emp3);
        Map<String,Long> demoList=empList.stream()
                                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("demoList = " + demoList);
    }

    public Map<Department, List<Employee>> getEmployeesGroupByDept(){
        return cache.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> getEmployeeSortedByAge(){
        return cache.values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }
}
