package com.CourseWork_2.CourseWork_2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping( "/get/{amount}")
    public ResponseEntity<Collection<Question>> getRandomQuestions(@PathVariable int amount) {
        try {
           return ResponseEntity.ok(examinerService.getQuestions(amount));
        } catch (NotEnoughQuestionsException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
