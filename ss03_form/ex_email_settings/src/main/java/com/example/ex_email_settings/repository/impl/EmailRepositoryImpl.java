package com.example.ex_email_settings.repository.impl;

import com.example.ex_email_settings.model.Email;
import com.example.ex_email_settings.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {
    private static Email setting;

    static {
        setting =new Email("Vietnamese", 25, false, "David");
    }
    @Override
    public Email show() {
        return setting;
    }

    @Override
    public void update(Email email) {
        setting.setLanguage(email.getLanguage());
        setting.setPageSize(email.getPageSize());
        setting.setSpam(email.isSpam());
        setting.setSignature(email.getSignature());
    }
}
