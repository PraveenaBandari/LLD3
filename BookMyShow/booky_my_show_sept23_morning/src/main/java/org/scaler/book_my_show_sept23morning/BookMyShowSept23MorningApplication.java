package org.scaler.book_my_show_sept23morning;

import org.scaler.book_my_show_sept23morning.controllers.UserController;
import org.scaler.book_my_show_sept23morning.dtos.ResponseStatus;
import org.scaler.book_my_show_sept23morning.dtos.SignUpRequestDTO;
import org.scaler.book_my_show_sept23morning.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowSept23MorningApplication implements CommandLineRunner {
    @Autowired
    UserController userController;

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO request = new SignUpRequestDTO();
        request.setEmail("mohit.sharma2@gmail.com");
        request.setPassword("mohit");

       SignUpResponseDTO responseDTO = userController.signUp(request);
        System.out.println(responseDTO.getMessage());
    }

    public static void main(String[] args) {

        SpringApplication.run(BookMyShowSept23MorningApplication.class, args);
    }

}


// HW : Finding Cardinality
// Generate the tables by running the code
// Book ticket feature discussion : How to block multiple people booking the same seats in the same show

// HW : please try to code the book ticket before next class

// Controllers
// Services
// repositories


// Implementing a basic user sign up
// completing the book ticket


// Controller , services