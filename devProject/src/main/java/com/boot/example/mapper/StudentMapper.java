package com.boot.example.mapper;

import com.boot.example.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Results(id = "studentResult", value = {
            @Result(property = "no", column = "no"),
            @Result(property = "studentNumber", column = "sd_num"),
            @Result(property = "studentName", column = "sd_name"),
            @Result(property = "studentId", column = "sd_id"),
            @Result(property = "studentBirth", column = "sd_birth"),
            @Result(property = "studentPhone", column = "sd_phone"),
            @Result(property = "studentAddress", column = "sd_address"),
            @Result(property = "studentEmail", column = "sd_email"),
            @Result(property = "regDate", column = "sd_date"),
            @Result(property = "subject.subjectNumber", column = "s_num"),
            @Result(property = "subject.subjectName", column = "s_name")
    })
    @Select("""
            SELECT ST.NO AS NO, SD_NUM, SD_NAME, SD_ID, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL, SD_DATE, SU.S_NUM AS S_NUM, S_NAME
            FROM STUDENT ST INNER JOIN SUBJECT SU
            ON ST.S_NUM = SU.S_NUM
            ORDER BY ST.NO
    """)
    public List<Student> studentList();
}
