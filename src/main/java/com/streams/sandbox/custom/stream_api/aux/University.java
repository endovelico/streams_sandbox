package com.streams.sandbox.custom.stream_api.aux;

import java.util.List;

public class University {
    private final String name;
    private final List<Course> courses;

    public University(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() { return name; }
    public List<Course> getCourses() { return courses; }
}
