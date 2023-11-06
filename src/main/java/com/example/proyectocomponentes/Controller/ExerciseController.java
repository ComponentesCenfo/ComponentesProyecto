package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.models.Exercise;
import com.example.proyectocomponentes.repository.IExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    @Autowired
    IExercise iExercise;

    @GetMapping("allExercises")
    public List<Exercise> getAllExercises(){
        return iExercise.findAll();
    }

}
