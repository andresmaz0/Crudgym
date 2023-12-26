package com.epam.gym.Crudgym.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "training_type")
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainingType_id;

    private String training_type_name;

    @OneToMany(mappedBy = "trainingType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Trainer> Trainers = new ArrayList<>();

    @OneToMany(mappedBy = "trainingType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Training> Trainings = new ArrayList<>();
}
