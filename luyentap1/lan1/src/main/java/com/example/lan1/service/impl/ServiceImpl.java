package com.example.lan1.service.impl;

import com.example.lan1.model.Student;
import com.example.lan1.repository.IRepository;
import com.example.lan1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements IService {

    @Autowired
    private IRepository repository;
    @Override
    public List<Student> showList() {
        return repository.showList();
    }

    @Override
    public void create(Student student) {
        repository.create(student);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(Student student) {
        repository.update(student);
    }

    @Override
    public Student detail(int id) {
        return repository.detail(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }
}
