package edu.devcci.justpractice.service;

import edu.devcci.justpractice.domain.mapper.TestMapper;
import edu.devcci.justpractice.domain.model.Board;
import edu.devcci.justpractice.domain.repository.BoardRepository;
import edu.devcci.justpractice.dto.BoardDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class TestService {
    private final TestMapper testMapper;
    private final BoardRepository boardRepository;
    private final GithubService githubService;

    @Autowired
    public TestService(TestMapper testMapper, BoardRepository boardRepository, GithubService githubService) {
        this.testMapper = testMapper;
        this.boardRepository = boardRepository;
        this.githubService = githubService;
    }

    public List<String> getTest() {
        try {
            githubService.getGitHubConnect();
        } catch (IOException e) {
            log.error("GithubService.getGitHubConnect() error", e);
        }
        return testMapper.selectTest();
    }


    public List<String> getTest2() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardDto> boardDtoList = boardList.stream()
                .map(board -> BoardDto.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .userId(board.getUser().getId())
                        .build()).collect(Collectors.toList()
                );
        return boardDtoList.stream()
                .map(BoardDto::getTitle)
                .collect(Collectors.toList());
    }
}
