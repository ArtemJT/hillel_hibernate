package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;

import java.sql.SQLException;
import java.util.List;

public interface CustomStudentRepo {

    String INSERT_STUDENT = "INSERT INTO class_db.student (stud_name, email) VALUES (:name, :email)";
    String DELETE_STUDENT = "DELETE FROM class_db.student WHERE id=:id";
    String SELECT_STUDENTS = "select s from Student s";
    String SELECT_STUDENT_BY_ID = "select s from Student s where s.id=:id";
    String UPDATE_STUDENT_EMAIL_BY_ID = "update Student s set s.email=:newEmail where s.id=:id";

    int addStudent(Student student);

    int deleteStudent(Student student);

    List<Student> findAllStudentsList();

    Student findStudentById(Integer id) throws SQLException;

    int changeStudentEmail(Student student, String newEmail);
}
