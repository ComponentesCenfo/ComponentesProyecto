package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.Exceptions.CustomException;
import com.example.proyectocomponentes.models.Client;
import com.example.proyectocomponentes.models.Trainer;
import com.example.proyectocomponentes.models.TrainingPlan;
import com.example.proyectocomponentes.repository.ITrainingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingPlanController {
    @Autowired
    ITrainingPlan iTrainingPlan;

    @PostMapping("createTrainingPlan")
    public ResponseEntity<Object> createTrainingPlan(@RequestBody TrainingPlan trainingPlan){
        try{
            trainingPlan.setStartDate(trainingPlan.getStartDate());
            trainingPlan.setEndDate(trainingPlan.getEndDate());
            trainingPlan.setExerciseList(trainingPlan.getExerciseList());
            iTrainingPlan.save(trainingPlan);
            Map<String, String> map = new HashMap<String, String>();
            map.put("actualizado", "Success");
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping("getTrainingPlan")
    public ResponseEntity<Object> getTrainingPlanByUserId(Integer client_id){
        try{
            iTrainingPlan.getTrainingPlanByUserId(client_id);
            Map<String, String> map = new HashMap<String, String>();
            map.put("actualizado", "Success");
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @PutMapping("editTrainingPlan")
    public ResponseEntity<Object> updateTrainingPlan(@RequestBody TrainingPlan u){
        try{
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
    public ResponseEntity<Object> deletePlan(@PathVariable(value = "client_id")Integer client_id){
        try{
            iTrainingPlan.deleteTrainingPlanByUserId(client_id);
            Map<String, String> map = new HashMap<String, String>();
            map.put("Borrado", "Success");
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
