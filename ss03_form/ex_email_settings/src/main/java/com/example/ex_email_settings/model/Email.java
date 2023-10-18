package com.example.ex_email_settings.model;

public class Email {
    private String language;
    private int pageSize;
    private boolean spam;
    private String signature;


    public Email() {
    }

    public Email(String languages, int pageSize, boolean spam, String signature) {
        this.language = languages;
        this.pageSize = pageSize;
        this.spam = spam;
        this.signature = signature;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "languages='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spam=" + spam +
                ", signature='" + signature + '\'' +
                '}';
    }
}
