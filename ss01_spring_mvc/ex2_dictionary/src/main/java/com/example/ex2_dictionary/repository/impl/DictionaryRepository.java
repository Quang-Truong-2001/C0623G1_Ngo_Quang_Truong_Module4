package com.example.ex2_dictionary.repository.impl;

import com.example.ex2_dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary=new HashMap<>();
    static {
        dictionary.put("apple","táo");
        dictionary.put("banana","chuối");
        dictionary.put("lemon","chanh");
    }
    @Override
    public String findByWord(String word) {
        String result=null;
        for(Map.Entry<String, String> entry: dictionary.entrySet()){
            if(entry.getKey().equals(word)){
                result = entry.getValue();
                break;
            }
        }
        return result;
    }
}
