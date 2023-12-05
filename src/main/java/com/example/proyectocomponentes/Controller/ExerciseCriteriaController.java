package com.example.proyectocomponentes.Controller;
import com.example.proyectocomponentes.models.ExerciseCriteria;
import com.example.proyectocomponentes.repository.IExerciseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://skytech-proyecto-gym.s3-website-us-east-1.amazonaws.com")
public class ExerciseCriteriaController {
    @Autowired
    IExerciseCriteria iExerciseCriteria;
    @GetMapping("allExerciseCriteria")
    public List<ExerciseCriteria> getAllExercises(){
        return iExerciseCriteria.findAll();
    }
    @PostMapping("createExerciseCriteria")
    public ExerciseCriteria createExercise(@RequestBody ExerciseCriteria exerciseCriteria){
        System.out.println(exerciseCriteria);
        exerciseCriteria.setExercise(exerciseCriteria.getExercise());
        exerciseCriteria.setRepetitions(exerciseCriteria.getRepetitions());
        exerciseCriteria.setSeries(exerciseCriteria.getSeries());
        exerciseCriteria.setTrainingPlan(exerciseCriteria.getTrainingPlan());
        return iExerciseCriteria.save(exerciseCriteria);
    }
    @DeleteMapping("deleteExerciseCriteria/{id}")
    public void deleteExercise(@PathVariable(value = "id")Integer id){
        iExerciseCriteria.deleteById(id);
    }
}
