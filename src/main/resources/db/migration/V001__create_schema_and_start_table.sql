CREATE SCHEMA IF NOT EXISTS class_db;

CREATE TABLE IF NOT EXISTS class_db.student
(
    id        serial not null primary key,
    stud_name text not null,
    email     varchar(255)
);