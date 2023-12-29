package com.epam.gym.Crudgym.Component;

import com.epam.gym.Crudgym.entity.User;
import com.epam.gym.Crudgym.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserExistence {

    @Autowired
    private UserRepository repo;

    private boolean existence;

    @Getter
    private String NewUsername;

    public boolean VerifyExistence(User user){
        List<User> users = repo.findAll();
        List<String> userNames = new ArrayList<>();
        userNames = users.stream().map(User::getUsername).toList();
        for(String username : userNames){
            if (username.equals(user.getUsername())) {
                existence = true;
                NewUsername = username;
                break;
            }
        }
        return existence;
    }
}
