package com.example.ex_email_settings.service.impl;

import com.example.ex_email_settings.model.Setting;
import com.example.ex_email_settings.repository.IEmailSettingRepository;
import com.example.ex_email_settings.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingServiceImpl implements IEmailSettingService {

    @Autowired
    private IEmailSettingRepository emailSettingRepository;
    @Override
    public Setting show() {
        return emailSettingRepository.show();
    }

    @Override
    public void update(Setting email) {
        emailSettingRepository.update(email);
    }
}
