package com.CourseWork_2.CourseWork_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTests {

    private JavaQuestionService javaQuestionService;

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService(javaQuestionRepositoryMock);
    }

    @Test
    void add_shouldAddQuestion() {
        Question question = new Question("Question", "Answer");
        when(javaQuestionRepositoryMock.add(eq(question)))
                .thenReturn(question);
        Question result = javaQuestionService.add("Question", "Answer");
        Assertions.assertEquals(question, result);
        verify(javaQuestionRepositoryMock).add(eq(question));
    }

    @Test
    void add_shouldAddQuestion2() {
        Question question = new Question("Question", "Answer");
        when(javaQuestionRepositoryMock.add(eq(question)))
                .thenReturn(question);
        Question result = javaQuestionService.add(question);
        Assertions.assertEquals(question, result);
        verify(javaQuestionRepositoryMock).add(eq(question));
    }

    @Test
    void remove_shouldRemoveQuestion() {
        Question question = new Question("Question", "Answer");
        when(javaQuestionRepositoryMock.remove(eq(question)))
                .thenReturn(question);
        Question result = javaQuestionService.remove(question);
        Assertions.assertEquals(question, result);
        verify(javaQuestionRepositoryMock).remove(eq(question));
    }

    @Test
    void getAll_shouldGet2Question() {
        Question question1 = new Question("Question", "Answer");
        Question question2 = new Question("Question1", "Answer1");
        when(javaQuestionRepositoryMock.getAll())
                .thenReturn(Set.of(question1, question2));
        Collection<Question> result = javaQuestionService.getAll();
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(question1));
        Assertions.assertTrue(result.contains(question2));
        verify(javaQuestionRepositoryMock).getAll();
    }
}
