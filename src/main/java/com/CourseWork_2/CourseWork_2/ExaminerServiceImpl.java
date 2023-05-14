package com.CourseWork_2.CourseWork_2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final Random random = new Random();
    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionServices.stream()
                .map(QuestionService::getAll)
                .map(Collection::size)
                .anyMatch(s -> amount > s)) {
            throw new NotEnoughQuestionsException();
        }

        return Stream.generate(() -> getRandomQuestionService().getRandomQuestion())
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());
    }

    private QuestionService getRandomQuestionService() {
        int i = random.nextInt(questionServices.size());
        return questionServices.get(i);
    }
}
