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

    @GetMapping("/test/db/mybatis")
    public ResponseEntity<String> getTest() {
        List<String> temp = testService.getTest();
        return ResponseEntity.ok(temp.toString());
    }

    @GetMapping("/test/db/jpa")
    public ResponseEntity<String> getTest2() {
        List<String> temp = testService.getTest2();
        return ResponseEntity.ok(temp.toString());
    }
}