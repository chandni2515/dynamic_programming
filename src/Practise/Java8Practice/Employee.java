package Practise.ep_que;


import java.util.UUID;


public class Employee {
    private UUID id;
    private int age;
    private String name;
    private Department department;
    private String gender;
    private long salary;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(UUID id, int age, String name, Department department, String gender, long salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }
}
