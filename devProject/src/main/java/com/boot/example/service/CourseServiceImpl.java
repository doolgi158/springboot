package com.boot.example.service;

import com.boot.example.domain.Course;
import com.boot.example.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
    private final CourseMapper courseMapper;

    @Override
    public List<Course> courseList() {
        return courseMapper.courseList();
    }
}
