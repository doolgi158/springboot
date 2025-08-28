package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void boardListTest() {
        Board board = null;
        boardMapper.boardList(board).stream().forEach(boardData -> log.info(boardData.toString()));
    }
}
