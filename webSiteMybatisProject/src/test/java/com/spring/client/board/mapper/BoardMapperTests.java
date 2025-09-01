package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

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

    @Test
    public void BoardInsertTest() {
        Board board = Board.builder()
                .boardName("김철수")
                .boardTitle("용기가 필요할 때")
                .boardContent("도중에 포기하지 말라. 망설이지 말라. 최후의 성공을 거둘 때까지 밀고 나가자.")
                .boardPasswd("1234").build();

        int count = boardMapper.boardInsert(board);
        log.info("입력된 행의 수: {}", count);
    }

    @Test
    public void readCntUpdateTest() {
        int boardNumber = 1;
        int count = boardMapper.readCntUpdate(boardNumber);
        log.info("수정된 행의 수: {}", count);
    }

    // Optional<T>는 null이 될 수도 있는 객체 T를 감싸는 래퍼 클래스로, null을 직접 다루지 않고도 안전하게 값의 존재 여부를 처리할 수 있게 해준다.
    @Test
    public void boardDetailTest() {
        int boardNumber = 1;
        Optional<Board> board = boardMapper.boardDetail(boardNumber);
        log.info("데이터 존재 여부: {}", board.isPresent());
        log.info("데이터 조회: {}", board.toString());;
    }

    @Test
    public void boardUpdateTest() {
        // 비밀번호 변경
        Board board = Board.builder()
                .boardTitle("만족도 평가")
                .boardContent("안녕하세요. 훈련과정의 중반부를 지나는 시점에 중간 만족도 평가를 진행합니다. 아래 안내드린 방법 참고하셔서 많은 참여 부탁드립니다!")
                .boardPasswd("ADMIN1234")
                .boardNumber(1)
                .build();

         /*비밀번호 변경하지 않을 때
        Board board = Board.builder()
                .boardTitle("만족도 평가")
                .boardContent("안녕하세요. 훈련과정의 중반부를 지나는 시점에 중간 만족도 평가를 진행합니다. 아래 안내드린 방법 참고하셔서 많은 참여 부탁드립니다!")
                .boardNumber(1)
                .build();*/

        int count = boardMapper.boardUpdate(board);
        log.info("게시판 수정된 행의 수: {}", count);
    }

    @Test
    public void boardDeleteTest() {
        int boardNumber = 1;    // 각자의 게시판 번호로 명시.
        log.info("게시판 삭제된 행의 수: {}", boardMapper.boardDelete(boardNumber));
    }

    // 일치: 1 / 불일치: 0
    @Test
    public void testPwdConfirm() {
        Board board = Board.builder().boardNumber(2).boardPasswd("asdf").build();
        int result = boardMapper.pwdConfirm(board);
        log.info("결과: {}", result);
        log.info("일치여부: {}", ((result == 1) ? "일치" : "불일치"));
    }
}
