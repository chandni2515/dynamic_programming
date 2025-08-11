package Practise.Java8;

import java.util.*;

public class Student {
//    private int id;
    private String name;
    private int age;
    private String gender;
    List<String> activities=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public Student(String name, int age, String gender, List<String> activities) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }
}
