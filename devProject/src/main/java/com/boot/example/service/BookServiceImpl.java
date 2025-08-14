package com.boot.example.service;

import com.boot.example.domain.Book;
import com.boot.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookMapper bookMapper;

    @Override
    public List<Book> bookList() {
        return bookMapper.bookList();
    }
}
