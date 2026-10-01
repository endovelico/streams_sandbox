package com.streams.sandbox.custom.stream_api;

import com.streams.sandbox.custom.stream_api.aux.Student;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

    public static void main(String[] args) {

        // ----- Sample students -----
        Student s1 = new Student("Alice", 20, "CS", List.of(90, 85, 88));
        Student s2 = new Student("Bob", 22, "Math", List.of(70, 75, 72));
        Student s3 = new Student("Charlie", 21, "CS", List.of(95, 92, 98));
        Student s4 = new Student("Diana", 23, "Physics", List.of(60, 65, 68));

        List<Student> students = List.of(s1, s2, s3, s4);

        // =========================================================
        // 1. FILTERING
        // =========================================================
        System.out.println("CS students:");
        students.stream()
                .filter(s -> s.getMajor().equals("CS"))
                .forEach(System.out::println);

        // =========================================================
        // 2. MAPPING
        // =========================================================
        System.out.println("\nStudent names:");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        // =========================================================
        // 3. SORTING
        // =========================================================
        System.out.println("\nSorted by average grade:");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::averageGrade).reversed())
                .forEach(System.out::println);

        // =========================================================
        // 4. REDUCE (manual aggregation)
        // =========================================================
        double overallAverage = students.stream()
                .mapToDouble(Student::averageGrade)
                .average()
                .orElse(0.0);

        System.out.println("\nOverall average grade: " + overallAverage);

        // =========================================================
        // 5. FLATMAP (important!)
        // =========================================================
        System.out.println("\nAll grades:");
        students.stream()
                .flatMap(s -> s.getGrades().stream())
                .forEach(System.out::println);

        // =========================================================
        // 6. GROUPING
        // =========================================================
        System.out.println("\nGrouped by major:");
        Map<String, List<Student>> byMajor =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getMajor));

        byMajor.forEach((major, group) -> {
            System.out.println(major + " -> " + group);
        });

        // =========================================================
        // 7. PARTITIONING (boolean split)
        // =========================================================
        System.out.println("\nPassed vs failed (avg >= 80):");
        Map<Boolean, List<Student>> partitioned =
                students.stream()
                        .collect(Collectors.partitioningBy(
                                s -> s.averageGrade() >= 80
                        ));

        System.out.println("Passed: " + partitioned.get(true));
        System.out.println("Failed: " + partitioned.get(false));

        // =========================================================
        // 8. COLLECT TO LIST
        // =========================================================
        List<String> topStudents =
                students.stream()
                        .filter(s -> s.averageGrade() > 85)
                        .map(Student::getName)
                        .collect(Collectors.toList());

        System.out.println("\nTop students: " + topStudents);
    }
}