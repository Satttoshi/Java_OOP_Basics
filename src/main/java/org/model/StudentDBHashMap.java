package org.model;

import java.util.*;

public class StudentDBHashMap {

    Map<Integer, Student> students;

    public StudentDBHashMap(Map<Integer, Student> students){
        this.students = students;
    }

    public Map<Integer, Student> getStudents(){
        return students;
    }

    public void addStudent(Integer id, Student student) {
        students.put(id, student);
    }

    public void removeStudent(Integer idToRemove) {
        students.remove(idToRemove);
    }


    @Override
    public String toString() {
        return "StudentDBSet{" +
            "students=" + students +
            '}';
    }

    private final Random random = new Random();
    public Student randomStudent(){
        return (Student) students.values().toArray()[random.nextInt(students.size())];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StudentDBHashMap that))
            return false;
        return Objects.equals(students, that.students) && Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, random);
    }
}
