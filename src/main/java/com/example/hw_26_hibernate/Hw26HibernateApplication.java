package com.example.hw_26_hibernate;

import com.example.hw_26_hibernate.dto.MarkDto;
import com.example.hw_26_hibernate.dto.StudentDto;
import com.example.hw_26_hibernate.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Hw26HibernateApplication {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Hw26HibernateApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        StudentDto dima = new StudentDto(null, "Dima", "dima@gm.com", null);
        dima = studentService.addStudent(dima);

        MarkDto markDto1 = new MarkDto(null, "history", "B");
        MarkDto markDto2 = new MarkDto(null, "math", "c");
        MarkDto markDto3 = new MarkDto(null, "chemistry", "d");

        studentService.addMarkToStudent(dima, markDto1);
        studentService.addMarkToStudent(dima, markDto2);
        studentService.addMarkToStudent(dima, markDto3);

        dima = studentService.getLastAddedStudent();
        log.info("dima: {}", dima);

        MarkDto chemMarkDtoNew = new MarkDto(null, "chemistry", "a");
        studentService.changeMarkForStudentByDiscipline(dima, chemMarkDtoNew);

        List<MarkDto> marksFromStudent = studentService.findAllMarksFromStudent(dima);
        marksFromStudent.forEach(markDto -> log.info("{}", markDto));


        StudentDto studentDto = new StudentDto(null, "delete", "email", null);
        studentDto = studentService.addStudent(studentDto);

        studentDto = studentService.changeStudentEmail(studentDto, "delete@email");

        log.info("studentDto after change email: {}", studentDto);

        Integer studentDtoId = studentDto.getId();
        StudentDto studentById = studentService.findStudentById(studentDtoId);

        boolean isEquals = studentDto.equals(studentById);
        log.info("isEquals studentDto and studentDtoById: {}", isEquals);

        studentService.addMarkToStudent(studentById, new MarkDto(null, "deletemark-", "-"));
        studentService.addMarkToStudent(studentById, new MarkDto(null, "deletemark222", "222"));

        List<StudentDto> allStudents = studentService.findAllStudents();
        allStudents.forEach(stdnt -> log.info("{}", stdnt));

        log.info("TRY TO FIND STUDENT BY ID {1111}...");
        studentService.findStudentById(1111);

        log.info("TRY TO DELETE STUDENT...");
        studentService.deleteStudentById(studentDto);
    }
}
