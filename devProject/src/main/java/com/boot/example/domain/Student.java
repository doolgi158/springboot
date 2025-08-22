package com.boot.example.domain;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private int no;
    private String studentNumber;
    private String studentName;
    private String studentId;
    private String studentPasswd;
    private String studentBirth;
    private String studentPhone;
    private String studentAddress;
    private String studentEmail;
    private Date regDate;

    private Subject subject;
}
