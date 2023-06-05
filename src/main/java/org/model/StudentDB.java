package org.model;

import java.util.Arrays;
import java.util.Objects;
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

    public void removeStudent(Student student) {
        Student[] newStudents = new Student[students.length - 1];
        int index = -1;
        for(int i = 0; i < students.length; i++){
            if(students[i].equals(student)){
                index = i;
                break;
            }
        }
        if(index != -1){

            if(index > 0) {
                System.arraycopy(students, 0, newStudents, 0, index);
            }
            if (index < students.length - 1) {
                System.arraycopy(students, index + 1, newStudents, index, students.length - index - 1);
            }
            students = newStudents;
        }
    }

    public int getLength() {
        return students.length;
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StudentDB studentDB = (StudentDB) o;
        return Arrays.equals(students, studentDB.students) && Objects.equals(random, studentDB.random);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(random);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
