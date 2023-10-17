package com.example.ex_email_settings.service;

import com.example.ex_email_settings.model.Setting;

public interface IEmailSettingService {
    Setting show();
    void update(Setting email);
}
