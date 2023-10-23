package com.example.ex_student.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountName;

    @OneToOne(mappedBy = "account")
    private Student student;

    public Account(Integer id, String accountName, Student student) {
        this.id = id;
        this.accountName = accountName;
        this.student = student;
    }

    public Account(String accountName, Student student) {
        this.accountName = accountName;
        this.student = student;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
