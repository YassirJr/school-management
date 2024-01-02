package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.UserDTO;
import com.schoolmanagement.server.entity.User;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    private ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO != null) {
            return ServerResponse.responseEntity(userDTO);
        }
        return ServerResponse.responseNotFound("User Not Found .");
    }

    @GetMapping
    private List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    private ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
        if (user != null) {
            userService.createUser(user);
            return ServerResponse.responseMessage("User created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this user , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateUser(@RequestBody @Valid User user) {
        if (user != null) {
            userService.updateUser(user);
            return ServerResponse.responseMessage("User updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this user , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        boolean isUserDeleted = userService.deleteUser(id);
        if (isUserDeleted) {
            return ServerResponse.responseMessage("User deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this user , try again .");
    }
}
