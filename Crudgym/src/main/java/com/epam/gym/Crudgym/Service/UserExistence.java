package com.epam.gym.Crudgym.Service;

import com.epam.gym.Crudgym.entity.User;
import com.epam.gym.Crudgym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserExistence {

    @Autowired
    private UserRepository repo;

    private List<String> userNames;
    private boolean existence;

    public boolean VerifyExistence(User user){
        List<User> users = repo.findAll();
        userNames = users.stream().map(User::getUsername).collect(Collectors.toList());
        for(String username : userNames){
            if(username.equals(user.getUsername())){
                existence = true;
            }
        }
        return existence;
    }
}
