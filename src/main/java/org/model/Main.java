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
            new Student("Canana", 22, 2),
            new Student("Debby", 23, 3),
        };

        StudentDB studentDB = new StudentDB(students);

        System.out.println(studentDB);

    }
}