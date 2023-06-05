package org.model;

import java.util.Objects;

public class Student {


    String name;
    int age;
    int points;

    public Student(){};

    public Student(String name, int age, int points) {
        this.name = name;
        this.age = age;
        this.points = points;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }


    public String toString(){
        return "[Name: " + this.name
            + " age: " + this.age
            + " points: " + this.points + " ]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && points == student.points && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, points);
    }
}
