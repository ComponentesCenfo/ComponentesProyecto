package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.Exceptions.CustomException;
import com.example.proyectocomponentes.models.Client;
import com.example.proyectocomponentes.models.Trainer;
import com.example.proyectocomponentes.models.TrainingPlan;
import com.example.proyectocomponentes.repository.ITrainingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")
public class TrainingPlanController {
    @Autowired
    ITrainingPlan iTrainingPlan;

    @PostMapping("createTrainingPlan")
    public ResponseEntity<Object> createTrainingPlan(@RequestBody TrainingPlan trainingPlan){
        try{
            trainingPlan.setCreationDate(Date.from(java.time.Instant.now()));
            trainingPlan.setStartDate(trainingPlan.getStartDate());
            trainingPlan.setEndDate(trainingPlan.getEndDate());
            trainingPlan.setClient(trainingPlan.getClient());
            trainingPlan.setTrainer(trainingPlan.getTrainer());
            iTrainingPlan.save(trainingPlan);
            return ResponseEntity.ok(trainingPlan);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @GetMapping("getLatestTrainingPlanByClientId")
    public TrainingPlan getLatestTrainingPlanByClientId(@RequestParam Integer clientId){
        try{
            TrainingPlan nearestTrainingPlan = iTrainingPlan.findLatestTrainingPlanByClientId(clientId);
            return nearestTrainingPlan;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("getAllTrainingPlanByClientId")
    public List<TrainingPlan> getAllTrainingPlanByClientId(@RequestParam Integer clientId){
        try{
            List<TrainingPlan> trainingPlans = iTrainingPlan.findAllTrainingPlansByClientId(clientId);
            return trainingPlans;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @GetMapping("getAllTrainingPlanByTrainerId")
    public List<TrainingPlan> getAllTrainingPlanByTrainerId(@RequestParam Integer trainerId){
        try{
            List<TrainingPlan> trainingPlans = iTrainingPlan.findAllTrainingPlansByTrainerId(trainerId);
            return trainingPlans;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @PutMapping("editTrainingPlan")
    public ResponseEntity<Object> updateTrainingPlan(@RequestBody TrainingPlan u){
        try{
            u.setCreationDate(u.getCreationDate());
            u.setStartDate(u.getStartDate());
            u.setEndDate(u.getEndDate());
            u.setClient(u.getClient());
            u.setTrainer(u.getTrainer());
            iTrainingPlan.save(u);
            Map<String, String> map = new HashMap<String, String>();
            map.put("actualizado", "Success");
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @DeleteMapping("deleteTrainingPlan")
    public ResponseEntity<Object> deletePlan(@PathVariable(value = "clientId")Integer clientId){
        try{
            iTrainingPlan.deleteTrainingPlanByClientId(clientId);
            Map<String, String> map = new HashMap<String, String>();
            map.put("Borrado", "Success");
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
