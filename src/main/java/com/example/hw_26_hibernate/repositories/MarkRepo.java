package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepo extends JpaRepository<Mark, Integer>, CustomMarkRepo {
}
