package com.example.lan1.repository;

import com.example.lan1.model.Student;

import java.util.List;

public interface IRepository {
    List<Student> showList();
    void create(Student student);
    void delete(int id);
    void update(Student student);
    Student detail(int id);
    List<Student> findByName(String name);
}
