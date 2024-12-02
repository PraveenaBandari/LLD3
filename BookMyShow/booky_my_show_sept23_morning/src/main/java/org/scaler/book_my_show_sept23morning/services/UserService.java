package org.scaler.book_my_show_sept23morning.services;

import org.scaler.book_my_show_sept23morning.models.User;
import org.scaler.book_my_show_sept23morning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(
            String email,
            String password
    ){
        // 1. check if the email is already registered
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName("Temp User");
        user.setLastName("");
        user.setUsername(email);
        user.setBookings(new ArrayList<>());

        return userRepository.save(user);
    }
}

// random data : account creation is in the process
// dummy user