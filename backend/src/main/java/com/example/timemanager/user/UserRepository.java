package com.example.timemanager.user;

import com.example.timemanager.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
