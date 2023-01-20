package com.example.hw_26_hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String discipline;

    @Column
    private String value;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
