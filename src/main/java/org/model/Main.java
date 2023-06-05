package org.model;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("John");
        student1.setAge(20);
        student1.setPoints(100);

        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Points: " + student1.getPoints());

        // Try out overwrited toString Method for shorthandle
        System.out.println(student1);

        Student student2 = new Student("Peter", 21, 69);
        System.out.println(student2);
    }
}