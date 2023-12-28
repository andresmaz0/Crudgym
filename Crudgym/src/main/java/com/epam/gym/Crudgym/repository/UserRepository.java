package com.epam.gym.Crudgym.repository;

import com.epam.gym.Crudgym.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
