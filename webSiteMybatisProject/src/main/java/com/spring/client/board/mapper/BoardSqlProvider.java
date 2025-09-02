package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import com.spring.common.dto.RequestDTO;

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

    public String selectListQuery(RequestDTO requestDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT B_NUM, B_NAME, B_TITLE, TO_CHAR(B_DATE, 'YYYY-MM-DD') AS b_date, B_READCNT ");
        sql.append("FROM SPRING_BOARD ");

        String condition = "";
        if("B_TITLE".equals(requestDTO.getSearch())) {
            condition = "B_TITLE LIKE '%' || #{keyword} || '%'";
        }else if("B_CONTENT".equals(requestDTO.getSearch())) {
            condition = "B_CONTENT LIKE '%' || #{keyword} || '%'";
        }else if("B_NAME".equals(requestDTO.getSearch())) {
            condition = "B_NAME LIKE '%' || #{keyword} || '%'";
        }

        if(!condition.isEmpty()) {
            sql.append("WHERE ").append(condition).append(" ");
        }

        sql.append("ORDER BY B_NUM DESC");

        return sql.toString();
    }
}
