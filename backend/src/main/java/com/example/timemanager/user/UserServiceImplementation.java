package com.example.timemanager.user;

import com.example.timemanager.User;
import com.example.timemanager.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User getUser(Integer id)
    {
        return userRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchElementException(
                        "NO CUSTOMER PRESENT WITH ID = " + id));
    }

    public String addUser(User user)
    {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(null);
        if(existingUser == null){
            userRepository.save(user);
            return "User created successfully";
        }
        else {
            throw new UserAlreadyExistsException("User already exists");
        }
    }

    public String updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElseThrow(null);
        if(existingUser == null){
            throw new UserAlreadyExistsException("No such user exists");
        }
        else{
            existingUser.setUserName(user.getUserName());
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(existingUser);
            return "Record update succesfully";
        }
    }



}
