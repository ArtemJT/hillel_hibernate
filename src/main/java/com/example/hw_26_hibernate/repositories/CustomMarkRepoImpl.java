package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Mark;
import com.example.hw_26_hibernate.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

public class CustomMarkRepoImpl implements CustomMarkRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public int addMarkToStudent(Student student, Mark mark) {
        Integer studentId = student.getId();
        String discipline = mark.getDiscipline();
        String value = mark.getValue().toUpperCase(Locale.ROOT);

        Query query = entityManager.createNativeQuery(INSERT_MARK);
        query.setParameter("studId", studentId);
        query.setParameter("disc", discipline);
        query.setParameter("value", value);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int changeMarkForStudentByDiscipline(Student student, Mark mark) {
        Integer studentId = student.getId();
        String discipline = mark.getDiscipline();
        String newMark = mark.getValue().toUpperCase(Locale.ROOT);

        Query query = entityManager.createQuery(UPDATE_MARK_BY_STUDENT_ID);
        query.setParameter("mark", newMark);
        query.setParameter("studId", studentId);
        query.setParameter("disc", discipline);

        return query.executeUpdate();
    }
}
