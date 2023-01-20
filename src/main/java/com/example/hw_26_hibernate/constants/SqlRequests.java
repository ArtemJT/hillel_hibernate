package com.example.hw_26_hibernate.constants;

public final class SqlConstants {

    public static final String INSERT_MARK = "INSERT INTO class_db.mark (student_id, discipline, value) VALUES (:studId, :disc, :mark)";
    public static final String INSERT_STUDENT = "INSERT INTO class_db.student (stud_name, email) VALUES (:name, :email)";
    public static final String DELETE_STUDENT = "DELETE FROM class_db.student WHERE id=:id";
    public static final String SELECT_STUDENTS = "select s from Student s";
    public static final String SELECT_STUDENT_BY_ID = "select s from Student s where s.id=:id";

}
