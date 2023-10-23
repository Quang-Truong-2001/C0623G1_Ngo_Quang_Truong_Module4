package com.example.ex_student.service.impl;

import com.example.ex_student.model.Student;
import com.example.ex_student.repository.IStudentRepository;
import com.example.ex_student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository repository;
    @Override
    public List<Student> showList() {
        return repository.findAll();
    }

    @Override
    public void create(Student student) {
        repository.save(student);
    }

    @Override
    public void update(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public Page<Student> showList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
