package com.example.hw_26_hibernate.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SqlRequests {

    public static final String INSERT_STUDENT = "INSERT INTO class_db.student (stud_name, email) VALUES (:name, :email)";
    public static final String DELETE_STUDENT = "DELETE FROM class_db.student WHERE id=:id";
    public static final String SELECT_STUDENTS = "select s from Student s";
    public static final String SELECT_STUDENT_BY_ID = "select s from Student s where s.id=:id";
    public static final String UPDATE_STUDENT_EMAIL_BY_ID = "update Student s set s.email=:newEmail where s.id=:id";

    public static final String INSERT_MARK = "INSERT INTO class_db.mark (student_id, discipline, value) VALUES (:studId, :disc, :value)";
    public static final String UPDATE_MARK_BY_STUDENT_ID = "update Mark m set m.value=:mark where m.student.id=:studId and m.discipline=:disc";

}
