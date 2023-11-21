package com.example.proyectocomponentes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private Integer sets;
    @Column
    private Integer time;
    @Column(nullable = true)
    private Integer repetitions;
    @Column(nullable = false)
    private String objectives;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="trainingPlan_id")
    @JsonBackReference
    private TrainingPlan trainingPlan;
}
