package com.CourseWork_2.CourseWork_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping( "/add")
    public ResponseEntity<Question> addQuestion(@RequestParam String question, @RequestParam String answer) {
        try {
            return ResponseEntity.ok(mathQuestionService.add(question, answer));
        } catch (MethodNotAllowedException e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
        }
    }

    @GetMapping( "/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        try {
            return ResponseEntity.ok(mathQuestionService.remove(question1));
        } catch (MethodNotAllowedException e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Question>> getQuestions() {
        try {
            return ResponseEntity.ok(mathQuestionService.getAll());
        } catch (MethodNotAllowedException e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
        }
    }
}
