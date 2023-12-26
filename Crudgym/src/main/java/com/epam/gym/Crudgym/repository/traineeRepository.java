package com.epam.gym.Crudgym.repository;

import com.epam.gym.Crudgym.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface traineeRepository extends JpaRepository<Trainee,Long> {
}
