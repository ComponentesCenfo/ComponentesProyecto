package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.models.Exercise;
import com.example.proyectocomponentes.repository.IExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    @Autowired
    IExercise iExercise;

    @GetMapping("allExercises")
    public List<Exercise> getAllExercises(){
        return iExercise.findAll();
    }
    @PostMapping("createExercise")
    public Exercise createExercise(@RequestBody Exercise exercise){
        exercise.setName(exercise.getName());
        exercise.setMuscleGroup(exercise.getMuscleGroup());
        return iExercise.save(exercise);
    }

    @GetMapping("exercise/byName/{name}")
    public String exerciseName(@PathVariable(value = "name")String name){
        return iExercise.byName(name);
    }
    @PutMapping("editExercise/{id}")
    public ResponseEntity<Exercise> editExercise(@PathVariable(value = "id")Integer id, @RequestBody Exercise exerciseUpdate){
        Optional<Exercise> exercise = iExercise.findById(id);
        exercise.get().setName(exerciseUpdate.getName());
        exercise.get().setMuscleGroup(exerciseUpdate.getMuscleGroup());
        Exercise updateExercise = iExercise.save(exercise.get());
        return ResponseEntity.ok(updateExercise);
    }

    @DeleteMapping("deleteExercise/{id}")
    public ResponseEntity<Exercise> deleteExercise(@PathVariable(value = "id")Integer id){
        Optional<Exercise> exercise = iExercise.findById(id);
        if (exercise.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        iExercise.deleteById(id);
        return ResponseEntity.ok(exercise.get());
    }

}
