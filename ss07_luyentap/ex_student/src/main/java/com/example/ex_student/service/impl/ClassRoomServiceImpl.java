package com.example.ex_student.service.impl;

import com.example.ex_student.model.ClassRoom;
import com.example.ex_student.repository.IClassRoomRepository;
import com.example.ex_student.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomServiceImpl implements IClassRoomService {

    @Autowired
    private IClassRoomRepository repository;
    @Override
    public List<ClassRoom> showListClassRoom() {
        return repository.findAll();
    }
}
