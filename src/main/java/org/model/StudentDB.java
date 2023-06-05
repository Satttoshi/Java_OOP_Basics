package org.model;

import java.util.Random;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students){
        this.students = students;
    }

    public Student[] getStudents(){
        return students;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.toString());
            if (student != students[students.length - 1]){
                result.append(", ");
            }
        }
        return result.toString();
    }

    private final Random random = new Random();
    public Student randomStudent(){
        return students[random.nextInt(students.length)];
    }
}
