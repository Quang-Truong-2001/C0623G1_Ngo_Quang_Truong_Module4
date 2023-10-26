package com.example.ex_book.service.impl;

import com.example.ex_book.model.Card;
import com.example.ex_book.repository.IRepositoryCard;
import com.example.ex_book.service.IServiceCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCardImpl implements IServiceCard {
    @Autowired
    private IRepositoryCard repository;
    @Override
    public void saveCode(Card card) {
        repository.save(card);
    }

    @Override
    public Card detail(Integer code) {
        return repository.findByCode(code);
    }

    @Override
    public void delete(Card card) {
        repository.delete(card);
    }

    @Override
    public List<Card> showMyBook() {
        return repository.findAll();
    }
}
