package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    @Results(id = "boardResult", value = {
            @Result(property = "boardNumber", column = "b_num"),
            @Result(property = "boardName", column = "b_name"),
            @Result(property = "boardTitle", column = "b_title"),
            @Result(property = "boardContent", column = "b_content"),
            @Result(property = "boardDate", column = "b_date"),
            @Result(property = "boardPasswd", column = "b_pwd"),
            @Result(property = "boardReadcnt", column = "b_readcnt")
    })
    @Select("""
            SELECT B_NUM, B_NAME, B_TITLE, TO_CHAR(B_DATE, 'YYYY-MM-DD') AS b_date, b_readcnt
            FROM SPRING_BOARD
            ORDER BY B_NUM DESC
            """)
    public List<Board> boardList(Board board);  // 검색 포함 리스트

    @Insert("""
            INSERT INTO SPRING_BOARD(B_NUM, B_NAME, B_TITLE, B_CONTENT, B_PWD)
            VALUES(SPRING_BOARD_SEQ.NEXTVAL, #{board.boardName}, #{board.boardTitle}, #{board.boardContent}, #{board.boardPasswd})
            """)
    public int boardInsert(@Param("board") Board board);

    @Update("UPDATE SPRING_BOARD SET B_READCNT = B_READCNT + 1 WHERE B_NUM = #{boardNumber}")
    public int readCntUpdate(@Param("boardNumber") int boardNumber);

    @ResultMap("boardResult")
    @Select("""
            SELECT B_NUM, B_NAME, B_TITLE, B_CONTENT, TO_CHAR(B_DATE, 'YYYY-MM-DD HH24:MI:SS') AS b_date, B_READCNT
            FROM SPRING_BOARD
            WHERE B_NUM = #{boardNumber}
            """)
    public Optional<Board> boardDetail(@Param("boardNumber") int boardNumber);

    @UpdateProvider(type = BoardSqlProvider.class, method = "updateQuery")
    public int boardUpdate(Board board);

    @Delete("DELETE FROM SPRING_BOARD WHERE B_NUM = #{boardNumber}")
    public int boardDelete(@Param("boardNumber") int boardNumber);

    @Select("""
            SELECT CASE WHEN EXISTS (
                    SELECT 1 FROM SPRING_BOARD
                    WHERE B_NUM = #{boardNumber} AND B_PWD = #{boardPasswd}) THEN 1
                    ELSE 0
                END AS state
            FROM DUAL
            """)
    public int pwdConfirm(Board board);
}
