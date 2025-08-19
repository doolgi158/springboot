package com.boot.example.mapper;

import com.boot.example.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BookMapperTests {
    @Autowired
    private BookMapper bookMapper;

    //@Test
    public void bookListTest() {
        bookMapper.bookList().stream().forEach((book -> log.info(book.toString())));
    }
    @Test
    public void testBookInsert() {
        Book book = Book.builder()
                .title("혼모노")
                .author("성해나")
                .publisher("창비")
                .publishDate("2025.03.28")
                .price(16200).build();
        int result = bookMapper.bookInsert(book);
        log.info("적용된 행의 수: {}", result);   // 로그 메시지 템플릿 -> {}는 변수명 명시.
    }

    @Test
    public void testBookDelete() {
        Book book = Book.builder().bookId(21).build();
        int result = bookMapper.bookDelete(book);
        log.info("삭제된 행의 수: {}", result);
    }
}
