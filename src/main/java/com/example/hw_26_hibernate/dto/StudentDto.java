package com.example.hw_26_hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;
    private String studName;
    private String email;
    private List<MarkDto> marks;
}
