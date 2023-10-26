package com.example.ex_book.service;

import com.example.ex_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceBook {
    Page<Book> showList(Pageable pageable);
    Book detail(Integer id);

    void save(Book book);
}
