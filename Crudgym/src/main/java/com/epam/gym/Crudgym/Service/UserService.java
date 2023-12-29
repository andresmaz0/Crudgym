package com.epam.gym.Crudgym.Service;

import com.epam.gym.Crudgym.Component.UserExistence;
import com.epam.gym.Crudgym.entity.User;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserExistence userExistence;
    private String firstName;
    private String lastName;
    private String username;

    public void CreatingUsername(User user){
        firstName = user.getFirstname();
        lastName = user.getLastname();
        username = firstName + "." + lastName;

        int lengthText;
        String digit;

        if(userExistence.VerifyExistence(user)){
            lengthText = userExistence.getNewUsername().length();
            digit = userExistence.getNewUsername().substring(lengthText-1);
            digit = String.valueOf((Integer.parseInt(digit)+1));
            username += digit;
            user.setUsername(username);
        }else {
            user.setUsername(username);
        }
    }
}
