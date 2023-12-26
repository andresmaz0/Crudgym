package com.epam.gym.Crudgym.controller;
import com.epam.gym.Crudgym.entity.Trainer;
import com.epam.gym.Crudgym.repository.trainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "")
public class TrainerController {

    @Autowired
    trainerRepository repo;

    String name_entity = "trainer";

    @GetMapping("getTrainer")
    public List<Trainer> getTrainers(){
        return repo.findAll();
    }

    @PostMapping("saveTrainer")
    public String post(@RequestBody Trainer trainer){
        repo.save(trainer);
        return "saved";
    }

    @PutMapping("editTrainer/{trainer_id}")
    public String update(@PathVariable Long trainer_id, @RequestBody Trainer trainer){
        Trainer updateTrainer = repo.findById(trainer_id).get();
        updateTrainer.setTrainingType(trainer.getTrainingType());
        repo.save(updateTrainer);
        return "Edit succesfull in id: " + trainer_id;
    }

    @DeleteMapping("deleteTrainer/{trainer_id}")
    public String delete(@PathVariable Long trainer_id){
        Trainer deleteTrainer = repo.findById(trainer_id).get();
        repo.delete(deleteTrainer);
        return "Delete succesfull in id:" + trainer_id;
    }
}
