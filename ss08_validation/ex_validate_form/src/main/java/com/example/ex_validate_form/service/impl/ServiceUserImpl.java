package com.example.ex_validate_form.service.impl;

import com.example.ex_validate_form.model.User;
import com.example.ex_validate_form.repository.IRepositoryUser;
import com.example.ex_validate_form.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserImpl implements IServiceUser {
    @Autowired
    private IRepositoryUser repository;
    @Override
    public void create(User user) {
        repository.save(user);
    }
}
