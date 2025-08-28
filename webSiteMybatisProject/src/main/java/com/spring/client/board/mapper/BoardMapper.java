package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
}
