CREATE TABLE IF NOT EXISTS class_db.mark
(
    id serial not null primary key,
    discipline text not null,
    value text not null,
    student_id int not null,
    FOREIGN KEY (student_id) REFERENCES class_db.student (id) ON DELETE CASCADE
);