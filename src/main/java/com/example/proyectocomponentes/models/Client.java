package com.example.proyectocomponentes.models;

import jakarta.persistence.*;
@Entity
@Table(name="Client")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "firstName", nullable = false)
        private String firstName;
        @Column(name = "lastName", nullable = false)
        private String lastName;
        @Column(name = "email", nullable = false)
        private String email;
        @Column(name = "phone", nullable = false)
        private Integer phone;
        @Column(name = "weight", nullable = false)
        private Float weight;
        @Column(name="age", nullable = false)
        private Integer age;
        @Column(name="sex", nullable = true)
        /*Booleno porque en este caso solo hay dos sexos(hombre o mujer), pero la persona puede decidir no incluir su sexo si no lo quiere hacer*/
        private boolean sex;

        public Client(){

        }

        public Client(String firstName, String lastName, String email, Integer phone, Float weight, Integer age, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.weight = weight;
            this.age = age;
            this.sex = sex;
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

        public Float getWeight() {
            return weight;
        }

        public void setWeight(Float weight) {
            this.weight = weight;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

}
