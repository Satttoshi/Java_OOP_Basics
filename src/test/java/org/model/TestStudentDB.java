package org.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TestStudentDB {

    @ParameterizedTest
    @MethodSource("provideStudentData")
    void test_getAllStudents(
        Student[] students
    ) {
        Student[] actual = new StudentDB(students).getStudents();

        Assertions.assertEquals(actual, students);
    }

    static Student[] students = new Student[]{
        new Student("Sahed", 21, 1),
        new Student("Canana", 22, 2),
        new Student("Debby", 23, 3),
    };
    static Stream<Arguments> provideStudentData() {
        return Stream.of(
            Arguments.of(
                (Object) students
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
}
