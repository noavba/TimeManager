package com.example.timemanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User getUser(Integer id)
    {
        return userRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchElementException(
                        "NO USER PRESENT WITH ID = " + id));
    }


    public String addUser(User user) {
        // Check if user already exists
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        // Create and save the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User created successfully";
    }

    public String updateUser(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new NoSuchElementException("No such user exists"));

        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(existingUser);
        return "Record updated successfully";
    }


    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String deleteUser(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User successfully deleted";
        } else {
            throw new NoSuchElementException("No user with given ID: " + id);
        }
    }
}
