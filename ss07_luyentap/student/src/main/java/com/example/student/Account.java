package com.example.student;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToOne(mappedBy = "account")
    private Student student;
}
