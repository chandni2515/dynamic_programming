package Practise.Java8;

import Practise.ep_que.Department;
import Practise.ep_que.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
//        1. Find the sum of all elements
        List<Integer> nums = Arrays.asList(1, 2, 5,3, 4, 5);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);

//        2. Find max element from list.
        int max = nums.stream().max(Integer::compare).get();
        int max1 = nums.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max = " + max);
        System.out.println("max using comparator = " + max1);

//    3. count the number of string that start with specific char
        List<String> fruits = Arrays.asList("apple", "banana", "coconut", "cherry", "berries", "cantaloupe");
        long count = fruits.stream().filter(fruit -> fruit.startsWith("c")).count();
        System.out.println("count: "+count);

//        4.convert strings in upercase
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);
        
//        5. Filter out even numbers using stream. Count number of ele that satisfy specific condition
        long evenCount = nums.stream().filter(num -> num % 2 == 0).count();
        System.out.println("evenCount = " + evenCount);

//        6. Find average of nums of float type
        List<Double> arr=Arrays.asList(1.1,2.1,3.4,2.3);
        arr.stream().mapToDouble(Double::doubleValue).average().ifPresent(System.out::println);
//        System.out.println("avg = " + avg);
        
//        7. Concate the strings
        String result = fruits.stream().collect(Collectors.joining(","));
        System.out.println("With join method: "+String.join("-",fruits));
        System.out.println("With collect method, result = " + result);

//        8. Remove duplicates from array
        nums.stream().distinct().forEach(System.out::println);

//        9. Sort the objects based on specific attribute
        List<Employee> employees = Arrays.asList(
                new Employee(UUID.randomUUID(), 20, "Alice", Department.ACCOUNTING, "F", 20000),
                new Employee(UUID.randomUUID(),30,"Charlie",Department.BILLING,"F",40000),
                new Employee(UUID.randomUUID(),28,"Zack",Department.PRODUCTION,"M",25000),
                new Employee(UUID.randomUUID(),24,"Mark",Department.BILLING,"M",55000),
                new Employee(UUID.randomUUID(),34,"Mark",Department.ACCOUNTING,"M",45000)
        );
        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(System.out::println);

//        10. Check if all ele satisfy specific condition

        boolean isEven = nums.stream().allMatch(num -> num % 2 == 0);
        boolean isEven1 = nums.stream().anyMatch(num -> num % 2 == 0);
        System.out.println("isEven = " + isEven);
        System.out.println("isEven1 = " + isEven1);


    }
}
