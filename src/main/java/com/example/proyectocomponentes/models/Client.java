package com.example.proyectocomponentes.models;

import jakarta.persistence.*;
import lombok.Data;

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
        private Integer phone;

        @Column(nullable = true)
        private Float weight;

        @Column(nullable = false)
        private Integer age;
        @Column(nullable = true)
        /*Booleno porque en este caso solo hay dos sexos(hombre o mujer), pero la persona puede decidir no incluir su sexo si no lo quiere hacer*/
        private String sex;

}
