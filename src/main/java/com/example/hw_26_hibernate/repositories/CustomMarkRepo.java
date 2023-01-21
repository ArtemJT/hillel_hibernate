package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Mark;
import com.example.hw_26_hibernate.entities.Student;

public interface CustomMarkRepo {

    String INSERT_MARK = "INSERT INTO class_db.mark (student_id, discipline, value) VALUES (:studId, :disc, :value)";
    String UPDATE_MARK_BY_STUDENT_ID = "update Mark m set m.value=:mark where m.student.id=:studId and m.discipline=:disc";

    int addMarkToStudent(Student student, Mark mark);

    int changeMarkForStudentByDiscipline(Student student, Mark mark);
}
