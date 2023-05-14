package com.CourseWork_2.CourseWork_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class MathQuestionService implements QuestionService{

    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        return new Question(a + " + " + b + " = ?", String.valueOf(a + b));
    }
}
