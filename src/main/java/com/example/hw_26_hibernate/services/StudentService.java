package com.example.hw_26_hibernate.services;

import com.example.hw_26_hibernate.dto.MarkDto;
import com.example.hw_26_hibernate.dto.StudentDto;
import com.example.hw_26_hibernate.entities.Mark;
import com.example.hw_26_hibernate.entities.Student;
import com.example.hw_26_hibernate.repositories.MarkRepo;
import com.example.hw_26_hibernate.repositories.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepo studentRepo;
    private final MarkRepo markRepo;
    private final ObjectMapper objectMapper;

    public StudentDto addStudent(@NonNull StudentDto studentDto) {
        Student student = mapStudentDtoToEntity(studentDto);
        int i = studentRepo.addStudent(student);
        if (i > 0) {
            studentDto = getLastAddedStudent();
            log.info("STUDENT {{}} ADDED SUCCESSFULLY", studentDto);
        } else {
            log.info("STUDENT {{}} WASN'T ADDED", studentDto);
        }
        return studentDto;
    }

    public void deleteStudentById(@NonNull StudentDto studentDto) {
        if (isDtoIdNotNull(studentDto)) {
            Student student = mapStudentDtoToEntity(studentDto);
            int i = studentRepo.deleteStudent(student);
            if (i > 0) {
                log.info("STUDENT {{}} DELETED SUCCESSFULLY", studentDto);
            } else {
                log.info("STUDENT {{}} WASN'T DELETE", studentDto);
            }
        }
    }

    public StudentDto changeStudentEmail(@NonNull StudentDto studentDto, @NonNull String newEmail) {
        if (isDtoIdNotNull(studentDto)) {
            Student student = mapStudentDtoToEntity(studentDto);
            int i = studentRepo.changeStudentEmail(student, newEmail);
            if (i > 0) {
                studentDto.setEmail(newEmail);
                log.info("STUDENT {{}} UPDATED SUCCESSFULLY", studentDto);
            } else {
                log.info("STUDENT {{}} WASN'T UPDATE", studentDto);
            }
        }
        return studentDto;
    }

    public StudentDto findStudentById(@NonNull Integer studentId) {
        Student student = findStudent(studentId);
        return student != null ? mapStudentEntityToDto(student) : null;
    }

    public List<StudentDto> findAllStudents() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentsList = studentRepo.findAllStudentsList();
        if (!studentsList.isEmpty()) {
            log.info("STUDENTS GOT SUCCESSFULLY");
            studentDtoList = studentsList.stream().map(this::mapStudentEntityToDto).toList();
        }
        return studentDtoList;
    }

    public List<MarkDto> findAllMarksFromStudent(@NonNull StudentDto studentDto) {
        List<MarkDto> markDtoList = new ArrayList<>();
        if (isDtoIdNotNull(studentDto)) {
            Student student = findStudent(studentDto.getId());
            if (student != null) {
                List<Mark> markList = student.getMarks();
                if (!markList.isEmpty()) {
                    markDtoList = markList.stream().map(mark -> objectMapper.convertValue(mark, MarkDto.class)).toList();
                }
            }
        }
        return markDtoList;
    }

    public MarkDto addMarkToStudent(@NonNull StudentDto studentDto, @NonNull MarkDto markDto) {
        Student student = mapStudentDtoToEntity(studentDto);
        Mark mark = objectMapper.convertValue(markDto, Mark.class);

        int i = markRepo.addMarkToStudent(student, mark);
        if (i > 0) {
            markDto.setId(mark.getId());
            log.info("MARK {{}} OF STUDENT {{}} ADDED SUCCESSFULLY", markDto, studentDto);
        } else {
            log.info("MARK {{}} OF STUDENT {{}} WASN'T ADD", markDto, studentDto);
        }
        return markDto;
    }

    public MarkDto changeMarkForStudentByDiscipline(@NonNull StudentDto studentDto, @NonNull MarkDto markDto) {
        if (isDtoIdNotNull(studentDto)) {
            Student student = mapStudentDtoToEntity(studentDto);
            Mark mark = objectMapper.convertValue(markDto, Mark.class);

            int i = markRepo.changeMarkForStudentByDiscipline(student, mark);
            if (i > 0) {
                markDto.setId(mark.getId());
                log.info("MARK OF STUDENT {{}} CHANGED SUCCESSFULLY", studentDto);
            } else {
                log.info("MARK OF STUDENT {{}} WASN'T CHANGED", studentDto);
            }
        }
        return markDto;
    }

    public StudentDto getLastAddedStudent() {
        return mapStudentEntityToDto(studentRepo.findFirstByOrderByIdDesc());
    }

    private Student findStudent(Integer studentId) {
        Student student = null;
        try {
            student = studentRepo.findStudentById(studentId);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return student;
    }

    private boolean isDtoIdNotNull(StudentDto studentDto) {
        if (studentDto.getId() == null) {
            log.info("STUDENT {{}} WASN'T FIND", studentDto);
            return false;
        }
        return true;
    }

    private Student mapStudentDtoToEntity(StudentDto studentDto) {
        return objectMapper.convertValue(studentDto, Student.class);
    }

    private StudentDto mapStudentEntityToDto(Student student) {
        return objectMapper.convertValue(student, StudentDto.class);
    }
}
