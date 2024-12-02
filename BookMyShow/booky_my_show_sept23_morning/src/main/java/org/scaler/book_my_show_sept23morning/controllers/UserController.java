package org.scaler.book_my_show_sept23morning.controllers;

import org.scaler.book_my_show_sept23morning.dtos.ResponseStatus;
import org.scaler.book_my_show_sept23morning.dtos.SignUpRequestDTO;
import org.scaler.book_my_show_sept23morning.dtos.SignUpResponseDTO;
import org.scaler.book_my_show_sept23morning.models.User;
import org.scaler.book_my_show_sept23morning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO request){
        SignUpResponseDTO response = new SignUpResponseDTO();

        try {
            User user = userService.signUp(
                    request.getEmail(),
                    request.getPassword()
            );
            response.setStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
            response.setMessage("User Successfully Signed Up");
        } catch (Exception ex){
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
