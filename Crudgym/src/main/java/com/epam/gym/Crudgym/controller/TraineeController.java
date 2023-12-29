package com.epam.gym.Crudgym.controller;

import com.epam.gym.Crudgym.entity.Trainee;
import com.epam.gym.Crudgym.repository.traineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "")
public class TraineeController {
    @Autowired
    traineeRepository repo;

    @GetMapping("getTrainee")
    public List<Trainee> getTrainees(){
        return repo.findAll();
    }

    @PostMapping("saveTrainee")
    public String post(@RequestBody Trainee trainee){
        repo.save(trainee);
        return "saved";
    }

    @PutMapping("editTrainee/{trainee_id}")
    public String update(@PathVariable Long trainee_id, @RequestBody Trainee trainee){
        Trainee updateTrainee = repo.findById(trainee_id).get();
        updateTrainee.setAddress(trainee.getAddress());
        updateTrainee.setDate_of_Birth(trainee.getDate_of_Birth());
        repo.save(updateTrainee);
        return "Edit succesfull in id: " + trainee_id;
    }

    @DeleteMapping("deleteTrainee/{trainee_id}")
    public String delete(@PathVariable Long trainee_id){
        Trainee deleteTrainee = repo.findById(trainee_id).get();
        repo.delete(deleteTrainee);
        return "Delete succesfull in id:" + trainee_id;
    }
}
