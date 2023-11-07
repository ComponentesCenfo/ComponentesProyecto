package com.example.proyectocomponentes.models;

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
    @Column(nullable = false)
    private Integer series;
    @Column(nullable = false)
    private Integer repetitions;
    @Column(nullable = false)
    private Integer time;
    @Column(nullable = false)
    private String objectives;
}
