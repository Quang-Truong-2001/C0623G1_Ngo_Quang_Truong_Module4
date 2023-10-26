package com.example.ex_book.repository;

import com.example.ex_book.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCard extends JpaRepository<Card, Integer> {
    Card findByCode(Integer code);
}
