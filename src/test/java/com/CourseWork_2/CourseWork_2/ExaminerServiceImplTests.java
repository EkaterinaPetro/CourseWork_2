package com.CourseWork_2.CourseWork_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExaminerServiceImplTests {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(List.of(javaQuestionServiceMock, mathQuestionServiceMock));
    }

    @Test
    void getQuestions_shouldGetQuestions() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");
        Question question4 = new Question("Question4", "Answer4");
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(question1)
                .thenReturn(question1)
                .thenReturn(question2);
        when(javaQuestionServiceMock.getAll())
                .thenReturn(List.of(question1,question2));
        when(mathQuestionServiceMock.getRandomQuestion())
                .thenReturn(question3)
                .thenReturn(question3)
                .thenReturn(question4);
        when(mathQuestionServiceMock.getAll())
                .thenReturn(List.of(question3,question4));

        Collection<Question> questions = examinerService.getQuestions(2);
        Assertions.assertEquals(2, questions.size());
        Set<Question> allQuestions = new HashSet<>();
        allQuestions.add(question1);
        allQuestions.add(question2);
        allQuestions.add(question3);
        allQuestions.add(question4);
        allQuestions.removeAll(questions);
        Assertions.assertEquals(2, allQuestions.size());
    }

    @Test
    void getQuestions_shouldThrowNotEnoughQuestionsException() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        when(javaQuestionServiceMock.getAll())
                .thenReturn(List.of(question1,question2));
        when(mathQuestionServiceMock.getAll())
                .thenReturn(List.of(question1));
        Assertions.assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(2));
    }
}
