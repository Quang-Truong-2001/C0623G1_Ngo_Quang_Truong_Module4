package com.example.ex_validate_form.repository;

import com.example.ex_validate_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User, Integer> {
}
