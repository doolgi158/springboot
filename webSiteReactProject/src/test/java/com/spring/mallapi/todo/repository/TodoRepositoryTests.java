package com.spring.mallapi.todo.repository;

import com.spring.mallapi.todo.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {
        for(int i = 1; i <= 100; i++) {
            Todo todo = Todo.builder()
                    .title("Title..." + i)
                    .dueDate(LocalDate.of(2025, 9, 5))
                    .writer("user00")
                    .build();
            todoRepository.save(todo);
        }
    }

    @Test
    public void testRead() {
        //  존재하는 번호로 확인
        Long tno = 33L;
        java.util.Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        log.info("데이터 조회(33L); {}", todo);
    }
}
