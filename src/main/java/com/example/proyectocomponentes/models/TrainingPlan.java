package com.example.proyectocomponentes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingPlan_id;

    private LocalDate creationDate = LocalDate.now();

    private LocalDate startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference("clientReference")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    @JsonBackReference("trainerReference")
    private Trainer trainer;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL)
    private List<ExerciseCriteria> exerciseCriterias;
}
