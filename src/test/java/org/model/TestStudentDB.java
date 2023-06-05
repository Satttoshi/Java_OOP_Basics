package org.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class TestStudentDB {

    private static final Student[] STUDENTS = new Student[]{
        new Student("Sahed", 21, 1),
        new Student("Canana", 22, 2),
        new Student("Debby", 23, 3),
    };

    @Test
    void test_getAllStudents() {
        StudentDB students = new StudentDB(STUDENTS);
        Student[] actual = students.getStudents();
        Assertions.assertEquals(STUDENTS, actual);

    }

    static Stream<Arguments> provideStudentData() {
        return Stream.of(
            Arguments.of(
                (Object) STUDENTS
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideStudentData")
    void test_toString(
        Student[] students
    ) {
        String expected = "[Name: Sahed, age: 21, points: 1], [Name: Canana, age: 22, points: 2], [Name: Debby, age: 23, points: 3]";
        StudentDB studentDB = new StudentDB(students);
        String actual = studentDB.toString();
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideStudentData")
    void test_randomStudent(
        Student[] students
    ) {
        StudentDB studentDB = new StudentDB(students);
        Student actual = studentDB.randomStudent();
        Assertions.assertNotNull(actual);
    }

    @ParameterizedTest
    @MethodSource("provideStudentData")
    void test_addStudent(
        Student[] students
    ) {
        StudentDB studentDB = new StudentDB(students);
        Student student = new Student("Peter", 21, 4);
        studentDB.addStudent(student);
        Student[] actual = studentDB.getStudents();
        Assertions.assertEquals(actual[actual.length - 1], student);
    }

    @Test
    void test_removeStudent() {
        Student[] students = new Student[]{
            new Student("Sahed", 21, 1),
            new Student("Canana", 22, 2),
            new Student("Debby", 23, 3),
            new Student("Peter", 21, 4),
        };

        StudentDB studentDB = new StudentDB(students);

        Student studentToRemove = students[1];

        studentDB.removeStudent(studentToRemove);

        Student[] updatedStudents = studentDB.getStudents();

        Assertions.assertFalse(Arrays.asList(updatedStudents).contains(studentToRemove), "Student should not be in the array after removal");
    }
}
