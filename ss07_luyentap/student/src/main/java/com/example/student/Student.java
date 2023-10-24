package com.example.student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classRoom_id", referencedColumnName = "id")
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Courses> courses;
}
