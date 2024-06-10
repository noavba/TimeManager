package com.example.timemanager;

import com.example.timemanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserService userService;
    //private UserRepository userRepository;
    //TODO: Figure out how to implement it so that username has to be unique (no duplicates) --
    //TODO: Figure out how to create and link to front end

    //TODO: web sessions?
    //TODO: Time manager - post/task creation >?

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

}
