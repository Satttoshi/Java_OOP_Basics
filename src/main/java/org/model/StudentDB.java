package org.model;

import java.util.Arrays;
import java.util.Random;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students){
        this.students = students;
    }

    public Student[] getStudents(){
        return students;
    }

    public void addStudent(Student student) {
        Student[] newStudents = Arrays.copyOf(students, students.length + 1);
        newStudents[newStudents.length - 1] = student;
        students = newStudents; // overwrite old array, change address pointer
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
