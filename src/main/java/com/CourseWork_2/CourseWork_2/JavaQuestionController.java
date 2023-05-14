package com.CourseWork_2.CourseWork_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping( "/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping( "/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return javaQuestionService.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }
}
