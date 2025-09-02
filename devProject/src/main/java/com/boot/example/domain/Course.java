package com.boot.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    private int no;
    private String courseNumber;
    private String courseName;
    private int courseCredit;
    private String courseSection;
}
