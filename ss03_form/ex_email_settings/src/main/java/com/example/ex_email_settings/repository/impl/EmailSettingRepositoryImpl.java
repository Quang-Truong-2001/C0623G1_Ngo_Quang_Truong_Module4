package com.example.ex_email_settings.repository.impl;

import com.example.ex_email_settings.model.Setting;
import com.example.ex_email_settings.repository.IEmailSettingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSettingRepositoryImpl implements IEmailSettingRepository {
    private static Setting setting;

    static {
        setting =new Setting("Vietnamese", 25, false, "David");
    }
    @Override
    public Setting show() {
        return setting;
    }

    @Override
    public void update(Setting email) {
        setting.setLanguage(email.getLanguage());
        setting.setPageSize(email.getPageSize());
        setting.setSpam(email.isSpam());
        setting.setSignature(email.getSignature());
    }
}
