package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.models.Exercise;
import com.example.proyectocomponentes.repository.IExerciseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseCriteriaController {

    @Autowired
    IExerciseCriteria iExerciseCriteria;

    @GetMapping("allExerciseCriteria")
    public List<Exercise> getAllExercises(){
        return iExerciseCriteria.findAll();
    }

    @PostMapping("createExerciseCriteria")
    public Exercise createExercise(@RequestBody Exercise exercise){
        exercise.setName(exercise.getName());
        exercise.setMuscleGroup(exercise.getMuscleGroup());
        return iExerciseCriteria.save(exercise);
    }

    @DeleteMapping("deleteExerciseCriteria/{id}")
    public void deleteExercise(@PathVariable(value = "id")Integer id){
        iExerciseCriteria.deleteById(id);
    }
}
