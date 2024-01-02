package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.RoleDTO;
import com.schoolmanagement.server.entity.Role;
import com.schoolmanagement.server.exception.MyCustomException;
import com.schoolmanagement.server.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(RoleDTO::toDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO getRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(RoleDTO::toDTO).orElse(null);
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    public boolean deleteRole(Long id) {
        try {
            Optional<Role> role = roleRepository.findById(id);
            if (role.isPresent()) {
                roleRepository.deleteById(id);
                return true;
            }
        } catch (DataIntegrityViolationException e) {
            throw new MyCustomException("The Role is assigned to user .");
        }
        return false;
    }
}
