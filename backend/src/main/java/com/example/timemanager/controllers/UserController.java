package com.example.timemanager.controllers;

import com.example.timemanager.user.User;
import com.example.timemanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //TODO: Unique Emails and gather firstname/hours goal details when creating accounts
    //TODO: start learning about JWT sessions
    //TODO: Create Tasks/Etc
    @GetMapping(path="/all")
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path="/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

    @PutMapping(path="/update")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping(path="/add")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);

    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PutMapping("/{id}/addHoursGoal")
    public String addHoursGoal(@PathVariable("id") Integer id, @RequestBody Integer hoursGoal){
        return userService.addHoursGoal(id, hoursGoal);
    }
}
