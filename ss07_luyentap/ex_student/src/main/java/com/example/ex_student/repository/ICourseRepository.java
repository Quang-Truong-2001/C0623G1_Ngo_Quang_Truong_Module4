package com.example.ex_student.repository;

import com.example.ex_student.model.Course;
import com.example.ex_student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
