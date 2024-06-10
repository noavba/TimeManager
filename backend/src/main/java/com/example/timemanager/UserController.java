package com.example.timemanager;

import com.example.timemanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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


    /*@PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String userName, @RequestParam String password, @RequestParam String email){

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));


        userRepository.save(newUser);
        return "Created new User";

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody String getUserById()
    */



    @PostMapping(path="/add")
    public String addUser(User user){
        return userService.addUser(user);
    }
}
