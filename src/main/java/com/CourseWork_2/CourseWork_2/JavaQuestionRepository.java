package com.CourseWork_2.CourseWork_2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        Question question1 = new Question("Что такое полиморфизм?", "Полиморфизм — это способность " +
                "программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе " +
                "этого объекта.");
        Question question2 = new Question("Что такое перегрузка методов?", "Перегрузка методов — это " +
                "свойство полиморфизма, в котором при помощи изменения сигнатуры метода можно создать разные методы " +
                "для одних действий.");

        add(question1);
        add(question2);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
