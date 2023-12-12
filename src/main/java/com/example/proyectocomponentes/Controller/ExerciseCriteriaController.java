package com.example.proyectocomponentes.Controller;
import com.example.proyectocomponentes.models.ExerciseCriteria;
import com.example.proyectocomponentes.repository.IExerciseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ExerciseCriteriaController {
    @Autowired
    IExerciseCriteria iExerciseCriteria;
    @GetMapping("allExerciseCriteria")
    public List<ExerciseCriteria> getAllExercises(){
            return iExerciseCriteria.findAll();
    }

    @PostMapping("createExerciseCriteria")
    public ExerciseCriteria createExercise(@RequestBody ExerciseCriteria exerciseCriteria){
        exerciseCriteria.setExercise(exerciseCriteria.getExercise());
        exerciseCriteria.setRepetitions(exerciseCriteria.getRepetitions());
        exerciseCriteria.setSeries(exerciseCriteria.getSeries());
        exerciseCriteria.setTrainingPlan(exerciseCriteria.getTrainingPlan());
        return iExerciseCriteria.save(exerciseCriteria);
    }
    @PutMapping("updateExerciseCriteria")
    public ExerciseCriteria updateExercise(@RequestBody ExerciseCriteria exerciseCriteria){
        ExerciseCriteria updateExerciseCriteria = iExerciseCriteria.findById(exerciseCriteria.getId()).get();
        updateExerciseCriteria.setExercise(exerciseCriteria.getExercise());
        updateExerciseCriteria.setRepetitions(exerciseCriteria.getRepetitions());
        updateExerciseCriteria.setSeries(exerciseCriteria.getSeries());
        updateExerciseCriteria.setTrainingPlan(exerciseCriteria.getTrainingPlan());
        return iExerciseCriteria.save(updateExerciseCriteria);
    }
    @DeleteMapping("deleteExerciseCriteria/{id}")
    public void deleteExercise(@PathVariable(value = "id")Integer id){
        iExerciseCriteria.deleteById(id);
    }
}
