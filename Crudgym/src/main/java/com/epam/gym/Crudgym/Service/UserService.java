package com.epam.gym.Crudgym.Service;

import com.epam.gym.Crudgym.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User user;
    private String firstName;

    private String lastName;

    public void CreatingUsername(User user){
        firstName = user.getFirstname();
        lastName = user.getLastname();
    }
}
