package org.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class TestStudentDB {

    private static final List<Student> STUDENTS = new ArrayList<>();
    static {
        STUDENTS.addAll(Arrays.asList(
            new Student("Sahed", 21, 1),
            new Student("Canana", 22, 2),
            new Student("Debby", 23, 3)
        ));
    }

    @Test
    void test_getAllStudents() {
        StudentDB students = new StudentDB(STUDENTS);
        List<Student> actual = students.getStudents();
        Assertions.assertEquals(STUDENTS, actual);

    }

    @Test
    void test_randomStudent() {
        StudentDB studentDB = new StudentDB(STUDENTS);
        Student actual = studentDB.randomStudent();
        Assertions.assertNotNull(actual);
    }

    @Test
    void test_addStudent() {
        StudentDB studentDB = new StudentDB(STUDENTS);
        Student student = new Student("Peter", 21, 4);
        studentDB.addStudent(student);
        List<Student> actual = studentDB.getStudents();
        Assertions.assertEquals(actual.get(actual.size() - 1), student);
    }

    @Test
    void test_removeStudent() {
        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(
            new Student("Sahed", 21, 1),
            new Student("Canana", 22, 2),
            new Student("Debby", 23, 3)
        ));

        StudentDB studentDB = new StudentDB(STUDENTS);

        Student studentToRemove = students.get(1);

        studentDB.removeStudent(studentToRemove);

        List<Student> updatedStudents = studentDB.getStudents();

        Assertions.assertFalse(Arrays.asList(updatedStudents).contains(studentToRemove), "Student should not be in the array after removal");
    }
}
