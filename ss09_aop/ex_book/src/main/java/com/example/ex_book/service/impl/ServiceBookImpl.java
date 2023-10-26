package com.example.ex_book.service.impl;

import com.example.ex_book.model.Book;
import com.example.ex_book.repository.IRepositoryBook;
import com.example.ex_book.service.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBookImpl implements IServiceBook {

    @Autowired
    private IRepositoryBook repository;
    @Override
    public Page<Book> showList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Book detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }
}
