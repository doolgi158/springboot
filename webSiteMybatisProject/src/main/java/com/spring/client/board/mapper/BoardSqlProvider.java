package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;

public class BoardSqlProvider {
    public String updateQuery(Board board) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE SPRING_BOARD SET ");
        sql.append("B_TITLE = #{boardTitle}, ");
        sql.append("B_CONTENT = #{boardContent}");
        if (board.getBoardPasswd() != null && !board.getBoardPasswd().isEmpty()) {
            sql.append(", B_PWD = #{boardPasswd} ");
        }
        sql.append("WHERE B_NUM = #{boardNumber} ");

        return sql.toString();
    }
}
