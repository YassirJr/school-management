package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.UserDTO;
import com.schoolmanagement.server.entity.User;
import com.schoolmanagement.server.exception.MyCustomException;
import com.schoolmanagement.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserDTO::toDTO).orElse(null);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                userRepository.deleteById(id);
                return true;
            }
        } catch (DataIntegrityViolationException e) {
            throw new MyCustomException("The Chef is assigned to departement .");
        }
        return false;
    }
}