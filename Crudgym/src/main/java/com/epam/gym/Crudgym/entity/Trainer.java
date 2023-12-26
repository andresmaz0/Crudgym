package com.epam.gym.Crudgym.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "trainers")
    private Set<Trainee> trainees = new HashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Training> trainings = new ArrayList<>();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "training_type_name")
    private TrainingType trainingType;
}
