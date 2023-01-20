package com.example.hw_26_hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Integer id;
    private String discipline;
    private String value;
}
