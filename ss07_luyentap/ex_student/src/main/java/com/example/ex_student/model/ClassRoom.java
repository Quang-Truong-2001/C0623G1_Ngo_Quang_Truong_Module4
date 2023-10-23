package com.example.ex_student.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;

    public ClassRoom(Integer id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public ClassRoom(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public ClassRoom() {
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

