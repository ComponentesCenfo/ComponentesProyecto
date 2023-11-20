package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainer extends JpaRepository<Trainer, Integer> {
    @Query("SELECT t.firstName ||' '|| t.lastName FROM Trainer t WHERE t.firstName = :name")
    String byName(@Param("name")String name);

    Trainer findByEmail(String email);
}
