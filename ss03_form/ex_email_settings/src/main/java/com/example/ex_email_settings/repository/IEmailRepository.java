package com.example.ex_email_settings.repository;

import com.example.ex_email_settings.model.Email;

public interface IEmailRepository {
    Email show();
    void update(Email email);
}
