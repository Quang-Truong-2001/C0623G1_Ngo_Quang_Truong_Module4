package com.example.ex_email_settings.repository;

import com.example.ex_email_settings.model.Setting;

public interface IEmailSettingRepository {
    Setting show();
    void update(Setting email);
}
