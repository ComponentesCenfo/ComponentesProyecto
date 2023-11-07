package com.example.proyectocomponentes.models;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table
public class Trainer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; @Column(nullable = false)
    private String firstName; @Column(nullable = false)
    private String lastName; @Column(nullable = false)
    private String email; @Column(nullable = false)
    private Integer phone;
}