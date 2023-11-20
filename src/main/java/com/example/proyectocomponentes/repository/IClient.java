package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClient extends JpaRepository<Client, Integer> {
    @Query("SELECT t.firstName ||' '|| t.lastName FROM Client t WHERE t.firstName = :name")
    public String byName(@Param("name")String name);

    public boolean existsByEmail(String email);

    public Client findClientByEmail(String email);
}
