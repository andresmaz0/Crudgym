package com.epam.gym.Crudgym.Component;

import com.epam.gym.Crudgym.entity.User;
import com.epam.gym.Crudgym.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreparingDataUser {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void initializeUser(){
        User user = new User();
        user.setFirstname("Alverto");
        user.setLastname("Rodrigez");
        user.setIsActive(Boolean.TRUE);

        userRepository.save(user);
    }

}
