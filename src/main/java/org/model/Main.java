package org.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(
            new Student("Sahed", 21, 1),
            new Student("Canana", 22, 2),
            new Student("Debby", 23, 3)
        ));

        StudentDB studentDB = new StudentDB(students);

        studentDB.addStudent(new Student("Peter", 21, 4));

        System.out.println(studentDB);

        studentDB.removeStudent(new Student ("Canana", 22, 2));

        System.out.println(studentDB);

        System.out.println(studentDB.randomStudent());
    }
}