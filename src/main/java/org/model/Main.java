package org.model;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setName("Peter");
        student1.setAge(21);
        student1.setPoints(69);

        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Points: " + student1.getPoints());

        // Try out overwrited toString Method for shorthandle
        System.out.println(student1);

        Student student2 = new Student("Peter", 21, 69);
        System.out.println(student2);

        // Try out overwrited equals Method
        System.out.println("Are the instances equal?: " + student1.equals(student2));

        Student[] students = new Student[]{
            new Student("Sahed", 21, 1),
            new Student("Canan", 22, 2),
            new Student("Debby", 23, 3),
        };

        StudentDB studentDB = new StudentDB(students);

        // Print out the students array get Students (Make visible in terminal)
        System.out.println(Arrays.toString(studentDB.getStudents()));

        // Print out the students array with overwrited toString Method
        System.out.println(studentDB);

        System.out.println("Random student: " + studentDB.randomStudent());

        studentDB.addStudent(new Student("Peter", 21, 4));
        System.out.println(studentDB);

        studentDB.removeStudent(students[2]);
        System.out.println(studentDB);
        System.out.println(studentDB.getStudents()[3]);

    }
}