package com.epam.gym.Crudgym.repository;

import com.epam.gym.Crudgym.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface trainerRepository extends JpaRepository<Trainer,Long> {
}
