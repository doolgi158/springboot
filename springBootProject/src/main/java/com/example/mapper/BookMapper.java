package com.example.mapper;

import com.example.VO.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Results(id = "bookresult", value = {
            @Result(property = "bookNo", column = "book_no"),
            @Result(property = "bookTitle", column = "title"),
            @Result(property = "bookWriter", column = "writer"),
            @Result(property = "bookPrice", column = "price")
    })
    @Select("""
            SELECT BOOK_NO, TITLE, WRITER, PRICE FROM BOOK1
            """)
    public List<Book> bookList();
}
