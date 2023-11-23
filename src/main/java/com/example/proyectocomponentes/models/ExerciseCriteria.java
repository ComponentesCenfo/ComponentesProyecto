package com.example.proyectocomponentes.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class ExerciseCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer repetitions;

    @Column(nullable = false)
    private Integer series;

}
