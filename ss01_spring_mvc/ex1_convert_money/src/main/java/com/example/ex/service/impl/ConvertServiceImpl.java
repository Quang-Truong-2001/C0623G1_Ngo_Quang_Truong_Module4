package com.example.ex.service.impl;

import com.example.ex.repository.IConvertRepository;
import com.example.ex.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Autowired
    private IConvertRepository convertRepository;

    @Override
    public double convertUSDToVND(double usd) {
        return convertRepository.convertUSDToVND(usd);
    }
}
