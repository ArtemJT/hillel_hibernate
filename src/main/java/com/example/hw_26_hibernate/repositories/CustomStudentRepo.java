package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;

import java.sql.SQLException;
import java.util.List;

public interface CustomStudentRepo {

    int addStudent(Student student);

    int deleteStudent(Student student);

    List<Student> findAllStudentsList();

    Student findStudentById(Integer id) throws SQLException;

    int changeStudentEmail(Student student, String newEmail);
}
