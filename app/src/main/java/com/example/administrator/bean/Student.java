package com.example.administrator.bean;

/**
 * Created by Administrator on 2017/8/25.
 */
public class Student {
    public String name;
    public String Course;

    public Student(String name, String course) {
        this.name = name;
        Course = course;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Course='" + Course + '\'' +
                '}';
    }
}
