package com.example.timemanager.user;

import com.example.timemanager.roles.ERole;
import com.example.timemanager.roles.Role;
import com.example.timemanager.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



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
        userRepository.save(user);
        return "User created successfully";
    }

    public String updateUser(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new NoSuchElementException("No such user exists"));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setPassword(user.getPassword());
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


    public User registerUser(User user){

        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new RuntimeException("Username already exists");
        }
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);


        return userRepository.save(user);



    }
    public String addHoursGoal(Integer id, Integer hoursGoal){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Such user exists"));

        existingUser.setHoursGoal(hoursGoal);
        userRepository.save(existingUser);
        return "Added " + hoursGoal + " amount of hours successfully to account";
    }
}
