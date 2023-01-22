package edu.devcci.justpractice.service;

import edu.devcci.justpractice.domain.model.Board;
import edu.devcci.justpractice.domain.repository.BoardRepository;
import edu.devcci.justpractice.dto.BoardDto;
import edu.devcci.justpractice.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    private final TestMapper testMapper;
    private final BoardRepository boardRepository;

    @Autowired
    public TestService(TestMapper testMapper, BoardRepository boardRepository) {
        this.testMapper = testMapper;
        this.boardRepository = boardRepository;
    }

    public List<String> getTest() {
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
