package com.example.ex_book.repository;

import com.example.ex_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRepositoryBook extends JpaRepository<Book, Integer> {
}
