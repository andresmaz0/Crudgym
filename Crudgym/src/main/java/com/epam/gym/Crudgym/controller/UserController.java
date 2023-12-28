package com.epam.gym.Crudgym.controller;

import com.epam.gym.Crudgym.Component.PreparingDataUser;
import com.epam.gym.Crudgym.entity.User;
import com.epam.gym.Crudgym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "")
public class UserController {
    @Autowired
    UserRepository repo;

    @Autowired
    PreparingDataUser dataUser;

    @GetMapping("getUser")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @PostMapping("saveUser")
    public String post(@RequestBody User user){
        repo.save(user);
        return "saved";
    }

    @PutMapping("editUser/{user_id}")
    public String update(@PathVariable Long user_id, @RequestBody User user){
        User updateUser = repo.findById(user_id).get();
        updateUser.setFirstname(user.getFirstname());
        updateUser.setLastname(user.getLastname());
        updateUser.setIsActive(user.getIsActive());
        repo.save(updateUser);
        return "Edit succesfull in id: " + user_id;
    }

    @DeleteMapping("deleteUser/{user_id}")
    public String delete(@PathVariable Long user_id){
        User deleteUser = repo.findById(user_id).get();
        repo.delete(deleteUser);
        return "Delete succesfull in id:" + user_id;
    }
}
