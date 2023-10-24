package com.example.proyectocomponentes.models;


import jakarta.persistence.*;

@Entity
@Table(name="Trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstName", nullable = false)
    private String firstName;
    @Column(name="lastName", nullable = false)
    private String lastName;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="phone", nullable = false)
    private Integer phone;

    public Trainer(){

    }

    public Trainer(String firstName, String lastName, String email, Integer phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
