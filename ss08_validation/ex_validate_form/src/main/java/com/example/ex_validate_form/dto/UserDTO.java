package com.example.ex_validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {
    @NotEmpty(message = "khong de trong")
    @Size(min = 5, max = 45,message = "do dai toi thieu 5 va do dai toi da 45 ky tu")
    private String firstName;
    @NotEmpty(message = "khong de trong")
    @Size(min = 5, max = 45,message = "do dai toi thieu 5 va do dai toi da 45 ky tu")
    private String lastName;

    private String phone;

    @NotNull(message = "khong de trong")
    @Min(value = 18,message = "Ban co du 18 tuoi khong")
    private Integer age;
    @NotEmpty(message = "khong de trong")
    @Email(message = "email khong hop le")
    private String email;

    public UserDTO(String firstName, String lastName, String phone, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public UserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        UserDTO user= (UserDTO) target;
        String phone= user.getPhone();
        ValidationUtils.rejectIfEmpty(errors,"phone","phone.empty" );
        if(phone.length()>11||phone.length()<10){
            errors.rejectValue("phone","phone.length");
        }
        if(!phone.startsWith("0")){
            errors.rejectValue("phone","phone.startsWith");
        }
        if(!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone","phone.matches");
        }
    }
}
