package org.model;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students){
        this.students = students;
    }

    public Student[] getStudents(){

        return students;
    }
}
