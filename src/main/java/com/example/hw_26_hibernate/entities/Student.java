package com.example.hw_26_hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String studName;

    @Column
    private String email;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Mark> marks;
}
