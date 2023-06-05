package org.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestStudentDB {

    @ParameterizedTest
    @MethodSource("provideStudentData")
    void test_getAllStudents(
        Student[] student1,
        Student[] expected
    ) {
        boolean actual = student1.equals(student2);

        Assertions.assertEquals(actual, expected);
    }

    static Stream<Arguments> provideStudentData() {
        return Stream.of(
            Arguments.of(
                new Student("Peter", 21, 69),
                new Student("Peter", 21, 69),
                true
            ),
            Arguments.of(
                new Student("Peter", 21, 69),
                new Student("Peter", 21, 70),
                false
            ),
            Arguments.of(
                new Student("Peter", 21, 69),
                new Student("Peter", 22, 69),
                false
            )
        );
    }
}


