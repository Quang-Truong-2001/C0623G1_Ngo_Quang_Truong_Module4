package com.example.ex2_dictionary.service.impl;

import com.example.ex2_dictionary.repository.IDictionaryRepository;
import com.example.ex2_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findByWord(String word) {
        return dictionaryRepository.findByWord(word);
    }
}
