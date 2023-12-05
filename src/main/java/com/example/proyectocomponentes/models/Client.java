package com.example.proyectocomponentes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false)
        private String email;

        @Column(nullable = true)
        private Long phone;

        @Column(nullable = true)
        private Float weight;

        @Column(nullable = true)
        private Float height;

        @Column(nullable = false)
        private Integer age;

        @Column(nullable = true)
        /*Booleno porque en este caso solo hay dos sexos(hombre o mujer), pero la persona puede decidir no incluir su sexo si no lo quiere hacer*/
        private String sex;

        @Column(nullable = false)
        private String password;

        @JsonIgnore
        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
        private List<TrainingPlan> trainingPlans;

}
