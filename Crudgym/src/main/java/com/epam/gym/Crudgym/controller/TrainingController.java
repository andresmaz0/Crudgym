package com.epam.gym.Crudgym.controller;

import com.epam.gym.Crudgym.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.gym.Crudgym.repository.trainingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "")
public class TrainingController {
    @Autowired
    trainingRepository repo;

    @GetMapping("getTraining")
    public List<Training> getTrainings(){
        return repo.findAll();
    }

    @PostMapping("saveTraining")
    public String post(@RequestBody Training training){
        repo.save(training);
        return "saved";
    }

    @PutMapping("editTraining/{training_id}")
    public String update(@PathVariable Long training_id, @RequestBody Training training){
        Training updateTraining = repo.findById(training_id).get();
        updateTraining.setTraining_name(training.getTraining_name());
        updateTraining.setTraining_date(training.getTraining_date());
        updateTraining.setTraining_duration(training.getTraining_duration());
        repo.save(updateTraining);
        return "Edit succesfull in id: " + training_id;
    }

    @DeleteMapping("deleteTraining/{training_id}")
    public String delete(@PathVariable Long training_id){
        Training deleteTraining = repo.findById(training_id).get();
        repo.delete(deleteTraining);
        return "Delete succesfull in id:" + training_id;
    }
}
