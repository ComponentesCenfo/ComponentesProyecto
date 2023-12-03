package com.example.proyectocomponentes.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    @JsonBackReference("exerciseReference")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="trainingPlan_id")
    private TrainingPlan trainingPlan;

}
