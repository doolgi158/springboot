package com.example.controller;

import com.example.VO.Book;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("selectAllList")
    public List<Book> selectAllList() {
        return service.selectAllList();
    }
}
