package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface CustomStudentRepo {

    void addStudent(String name, String email);

    void deleteStudentById(Integer studentId);

    void addMarkToStudent(Integer studentId, String mark);

    List<Student> getAllStudentsList();

    Student getStudentById(Integer id);
}
