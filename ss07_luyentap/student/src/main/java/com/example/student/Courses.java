package com.example.student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> student;
}
