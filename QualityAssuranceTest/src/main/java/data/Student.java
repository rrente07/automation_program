package data;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String lastname;
    private String email;
    private int age;
    private String country;
    private String data;
    List<String> nameOfCourses;

    public Student(String name, String lastname, String country, String data) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.data = data;
        nameOfCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getNameOfCourses() {
        return nameOfCourses;
    }

    public void AddCourse (String course) {
        this.nameOfCourses.add(course);
    }
}
