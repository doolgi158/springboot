package com.boot.example.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentMapperTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void StudentListTest() {
        studentMapper.studentList().stream().forEach((student -> log.info(student.toString())));
    }
}
