package com.boot.example.mapper;

import com.boot.example.domain.Student;
import org.apache.ibatis.annotations.*;

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

    @Select("""
            SELECT TO_CHAR(SYSDATE, 'YY') || S.S_NUM ||
                LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ST.SD_NUM, 5))), 0) + 1, 4, '0') AS student_number
            FROM SUBJECT S LEFT JOIN STUDENT ST
            ON S.S_NUM = ST.S_NUM
            WHERE S.S_NUM = #{subjectNumber}
            GROUP BY S.S_NUM
            """)
    public String studentAutoNumber(@Param("subjectNumber") String subjectNumber);

    @Select("""
            SELECT CASE
                    WHEN EXISTS (SELECT 1 FROM STUDENT WHERE SD_ID = #{studentId})
                    THEN 1
                    ELSE 0
                END AS RESULT
            FROM DUAL
            """)
    public int studentIdCheck(@Param("studentId") String studentId);

    @Insert("""
            INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL)
            VALUES(STUDENT_SEQ.NEXTVAL, #{student.studentNumber}, #{student.studentName}, #{student.studentId}, #{student.studentPasswd},
                    #{student.subject.subjectNumber}, #{student.studentBirth}, #{student.studentPhone}, #{student.studentAddress}, #{student.studentEmail})
            """)
    public int studentInsert(@Param("student") Student student);

}
