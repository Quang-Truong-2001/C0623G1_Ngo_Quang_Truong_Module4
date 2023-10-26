package com.example.ex_book.service;

import com.example.ex_book.model.Card;

import java.util.List;

public interface IServiceCard {
    void saveCode(Card card);
    Card detail(Integer code);

    void delete(Card card);

    List<Card> showMyBook();
}
