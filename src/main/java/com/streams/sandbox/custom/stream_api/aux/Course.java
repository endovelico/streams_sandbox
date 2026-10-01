package com.streams.sandbox.custom.stream_api.aux;

import java.util.List;

public class Course {
    private final String name;
    private final List<Student> students;

    public Course(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() { return name; }
    public List<Student> getStudents() { return students; }

    @Override
    public String toString() {
        return name;
    }
}
