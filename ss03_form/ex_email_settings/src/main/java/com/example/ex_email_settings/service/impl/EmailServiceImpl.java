package com.example.ex_email_settings.service.impl;

import com.example.ex_email_settings.model.Email;
import com.example.ex_email_settings.repository.IEmailRepository;
import com.example.ex_email_settings.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private IEmailRepository emailSettingRepository;
    @Override
    public Email show() {
        return emailSettingRepository.show();
    }

    @Override
    public void update(Email email) {
        emailSettingRepository.update(email);
    }
}
