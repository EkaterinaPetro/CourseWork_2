package com.CourseWork_2.CourseWork_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathQuestionServiceTests {

    @Autowired
    private MathQuestionService mathQuestionService;

    @Test
    void add_shouldThrowMethodNotAllowedException() {
        Assertions.assertThrows(MethodNotAllowedException.class, () -> mathQuestionService
                .add("Question", "Answer"));
    }

    @Test
    void add_shouldThrowMethodNotAllowedException2() {
        Question question = new Question("Question", "Answer");
        Assertions.assertThrows(MethodNotAllowedException.class, () -> mathQuestionService
                .add(question));
    }

    @Test
    void remove_shouldThrowMethodNotAllowedException() {
        Question question = new Question("Question", "Answer");
        Assertions.assertThrows(MethodNotAllowedException.class, () -> mathQuestionService
                .remove(question));
    }

    @Test
    void getAll_shouldThrowMethodNotAllowedException() {
        Assertions.assertThrows(MethodNotAllowedException.class, () -> mathQuestionService
                .getAll());
    }
}
