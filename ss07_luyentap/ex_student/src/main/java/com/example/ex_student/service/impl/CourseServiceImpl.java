package com.example.ex_student.service.impl;

import com.example.ex_student.model.ClassRoom;
import com.example.ex_student.model.Course;
import com.example.ex_student.repository.IClassRoomRepository;
import com.example.ex_student.repository.ICourseRepository;
import com.example.ex_student.service.IClassRoomService;
import com.example.ex_student.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository repository;

    @Override
    public List<Course> showListClassCourse() {
        return repository.findAll();
    }
}
