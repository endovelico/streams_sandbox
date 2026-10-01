package com.streams.sandbox.custom.stream_api.aux;

import java.util.List;

public class Student {
    private final String name;
    private final int age;
    private final String major;
    private final List<Integer> grades;

    public Student(String name, int age, String major, List<Integer> grades) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.grades = grades;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }
    public List<Integer> getGrades() { return grades; }

    public double averageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return name + " (" + major + ", avg=" + averageGrade() + ")";
    }
}