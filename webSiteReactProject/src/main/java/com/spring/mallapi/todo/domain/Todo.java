package com.spring.mallapi.todo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_todo")
@SequenceGenerator(name = "tbl_todo_generator",
    sequenceName = "tbl_todo_seq",
    initialValue = 1,
    allocationSize = 1)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_todo_generator")
    private Long tno;

    private String title;
    private String writer;
    private boolean complete;
    private LocalDate dueDate;

}
