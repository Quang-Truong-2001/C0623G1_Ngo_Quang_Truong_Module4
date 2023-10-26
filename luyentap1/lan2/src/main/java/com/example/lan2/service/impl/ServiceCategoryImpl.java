package com.example.lan2.service.impl;

import com.example.lan2.model.Category;
import com.example.lan2.repository.IRepositoryCategory;
import com.example.lan2.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCategoryImpl implements IServiceCategory {

    @Autowired
    private IRepositoryCategory repository;
    @Override
    public List<Category> showList() {
        return repository.findAll();
    }
}
