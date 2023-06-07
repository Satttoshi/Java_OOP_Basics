package org.model;

import java.util.*;

public class StudentDB {

    List<Student> students;

    public StudentDB(List<Student> students){
        this.students = students;
    }

    public List<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.toString());
            if (student != students.get(students.size() - 1)){
                result.append(", ");
            }
        }
        return result.toString();
    }

    private final Random random = new Random();
    public Student randomStudent(){
        return students.get(random.nextInt(students.size()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StudentDB studentDB))
            return false;
        return Objects.equals(students, studentDB.students) && Objects.equals(random, studentDB.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, random);
    }
}
