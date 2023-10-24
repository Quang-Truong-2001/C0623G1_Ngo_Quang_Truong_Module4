package com.example.student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "classRoom")
    private Set<Student> student;
}
