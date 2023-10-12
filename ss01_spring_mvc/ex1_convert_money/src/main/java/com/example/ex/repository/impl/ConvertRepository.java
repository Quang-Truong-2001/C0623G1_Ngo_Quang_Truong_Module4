package com.example.ex.repository.impl;

import com.example.ex.repository.IConvertRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepository implements IConvertRepository {

    @Override
    public double convertUSDToVND(double usd) {
        return usd*23000;
    }
}
