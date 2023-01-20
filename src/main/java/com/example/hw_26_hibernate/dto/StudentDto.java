package com.example.hw_26_hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @JsonIgnore
    private List<Mark> marks;
}
