package com.example.ex_student.service;

import com.example.ex_student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void create(Student student);
    void update(Student student);
    void delete(Integer id);

    Student findById(Integer id);
    List<Student> findByName(String name);
    Page<Student> showList(Pageable pageable);
}
