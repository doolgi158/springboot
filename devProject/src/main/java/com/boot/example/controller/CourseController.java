package com.boot.example.controller;

import com.boot.example.domain.Course;
import com.boot.example.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("courseList")
    public List<Course> courseList(){
        return courseService.courseList();
    }
}
