package org.model;

import java.util.*;

public class StudentDBSet {

    Set<Student> students;

    public StudentDBSet(Set<Student> students){
        this.students = students;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }


    @Override
    public String toString() {
        return "StudentDBSet{" +
            "students=" + students +
            '}';
    }

    private final Random random = new Random();
    public Student randomStudent(){
        return (Student) students.toArray()[random.nextInt(students.size())];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StudentDBSet that))
            return false;
        return Objects.equals(students, that.students) && Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, random);
    }
}
