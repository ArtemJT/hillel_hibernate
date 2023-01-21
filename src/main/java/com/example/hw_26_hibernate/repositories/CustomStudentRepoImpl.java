package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class CustomStudentRepoImpl implements CustomStudentRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public int addStudent(Student student) {
        String name = student.getStudName();
        String email = student.getEmail();
        Query query = entityManager.createNativeQuery(INSERT_STUDENT);
        query.setParameter("name", name);
        query.setParameter("email", email);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int deleteStudent(Student student) {
        Integer studentId = student.getId();
        Query query = entityManager.createNativeQuery(DELETE_STUDENT);
        query.setParameter("id", studentId);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int changeStudentEmail(Student student, String newEmail) {
        Integer studentId = student.getId();
        Query query = entityManager.createQuery(UPDATE_STUDENT_EMAIL_BY_ID);
        query.setParameter("newEmail", newEmail);
        query.setParameter("id", studentId);

        return query.executeUpdate();
    }

    @Override
    public Student findStudentById(Integer studentId) throws SQLException {
        Query query = entityManager.createQuery(SELECT_STUDENT_BY_ID);
        query.setParameter("id", studentId);
        try {
            return (Student) query.getSingleResult();
        } catch (NoResultException e) {
            throw new SQLException("STUDENT WITH ID=" + studentId + " WASN'T FOUND");
        }
    }

    @Override
    public List<Student> findAllStudentsList() {
        return entityManager.createQuery(SELECT_STUDENTS).getResultList();
    }
}
