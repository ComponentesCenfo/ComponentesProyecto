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

    private LocalDate startDate;

    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer_id;

    @OneToMany(mappedBy = "trainingPlan",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Exercise> exerciseList;
}
