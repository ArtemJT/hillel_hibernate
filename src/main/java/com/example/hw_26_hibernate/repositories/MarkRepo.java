package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
}
