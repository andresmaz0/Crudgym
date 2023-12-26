package com.epam.gym.Crudgym.repository;

import com.epam.gym.Crudgym.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface trainingRepository extends JpaRepository<Training,Long> {
}
