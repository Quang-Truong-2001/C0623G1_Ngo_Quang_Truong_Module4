package com.example.orm.dto;

import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class StudentDTO implements Validator {

    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;

    public StudentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO =(StudentDTO) target;
        if(!studentDTO.getName().matches("^[ \\w]+$")){
            errors.rejectValue("name","","Ten khong chua cac ki tu dac biet");
        }
        if(!studentDTO.getPhone().matches("^08[0-9]{6}$")){
            errors.rejectValue("phone","","So dien thoai khong dung");
        }
    }
}
