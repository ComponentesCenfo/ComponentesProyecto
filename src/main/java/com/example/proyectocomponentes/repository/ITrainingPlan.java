package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Client;
import com.example.proyectocomponentes.models.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainingPlan extends JpaRepository<TrainingPlan, Integer> {
    @Query("SELECT tp FROM TrainingPlan tp WHERE tp.client.id = :clientId ORDER BY tp.creationDate DESC LIMIT 1")
    TrainingPlan findLatestTrainingPlanByClientId(@Param("clientId") Integer clientId);

    @Query("DELETE from TrainingPlan p where p.client.id = :client_id")
    TrainingPlan deleteTrainingPlanByUserId(@Param("client_id") Integer client_id);
}
