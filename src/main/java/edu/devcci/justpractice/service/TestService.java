package edu.devcci.justpractice.service;

import edu.devcci.justpractice.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<String> getTest() {
        return testMapper.selectTest();
    }
}
