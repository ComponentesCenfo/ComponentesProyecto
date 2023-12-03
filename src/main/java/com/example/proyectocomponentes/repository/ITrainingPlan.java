package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Client;
import com.example.proyectocomponentes.models.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITrainingPlan extends JpaRepository<TrainingPlan, Integer> {
    @Query("Select p from TrainingPlan p where p.client.id = :client_id")
    List<TrainingPlan> getTrainingPlanByUserId(@Param("client_id") Integer client_id);

    @Query("DELETE from TrainingPlan p where p.client.id = :client_id")
    TrainingPlan deleteTrainingPlanByUserId(@Param("client_id") Integer client_id);
}
