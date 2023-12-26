package com.epam.gym.Crudgym.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long training_id;

    @Column(nullable = false)
    private String training_name;

    @Column(nullable = false)
    private java.sql.Date training_date;

    @Column(nullable = false)
    private Integer training_duration;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "training_type_name")
    private TrainingType trainingType;

}
