package edu.devcci.justpractice.service;

import edu.devcci.justpractice.domain.model.User;
import edu.devcci.justpractice.domain.repository.UserRepository;
import edu.devcci.justpractice.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    private final TestMapper testMapper;
    private final UserRepository userRepository;

    @Autowired
    public TestService(TestMapper testMapper, UserRepository userRepository) {
        this.testMapper = testMapper;
        this.userRepository = userRepository;
    }

    public List<String> getTest() {
        return testMapper.selectTest();
    }

    public List<String> getTest2() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(User::getId).collect(Collectors.toList());
    }
}
