package com.example.ex_student.repository;

import com.example.ex_student.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
