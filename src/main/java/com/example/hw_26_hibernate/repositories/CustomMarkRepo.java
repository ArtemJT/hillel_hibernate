package com.example.hw_26_hibernate.repositories;

import com.example.hw_26_hibernate.entities.Mark;
import com.example.hw_26_hibernate.entities.Student;

public interface CustomMarkRepo {

    int addMarkToStudent(Student student, Mark mark);

    int changeMarkForStudentByDiscipline(Student student, Mark mark);
}
