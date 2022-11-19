package edu.devcci.justpractice.controller;

import edu.devcci.justpractice.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        List<String> temp = testService.getTest();
        return ResponseEntity.ok(temp.toString());
    }
}