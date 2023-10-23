package com.example.ex_student.model;

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
    @JoinColumn(name = "classroom_id",referencedColumnName = "id")
    private ClassRoom classRoom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses",
                joinColumns = @JoinColumn(name="student_id"),
                inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private Set<Course> courses;


    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Student(String name, Account account, ClassRoom classRoom, Set<Course> courses) {
        this.name = name;
        this.account = account;
        this.classRoom = classRoom;
        this.courses = courses;
    }

    public Student(Integer id, String name, Account account, ClassRoom classRoom, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.classRoom = classRoom;
        this.courses = courses;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Student(Integer id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public Student(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public Student() {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
