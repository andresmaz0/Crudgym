package com.epam.gym.Crudgym.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long trainee_id;

    @Getter
    @Setter
    private java.sql.Date Date_of_Birth;

    @Getter
    @Setter
    private String Address;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @ManyToMany
    @JoinTable(
            name = "trainee with trainer",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id"))
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Training> trainings = new ArrayList<>();
}
