package com.example.lan1.service;

import com.example.lan1.model.Student;

import java.util.List;

public interface IService {
    List<Student> showList();
    void create(Student student);
    void delete(int id);
    void update(Student student);
    Student detail(int id);
    List<Student> findByName(String name);
}
