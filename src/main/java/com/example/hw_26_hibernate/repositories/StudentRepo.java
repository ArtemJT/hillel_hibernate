package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>, CustomStudentRepo {

    Student findFirstByOrderByIdDesc();
}
