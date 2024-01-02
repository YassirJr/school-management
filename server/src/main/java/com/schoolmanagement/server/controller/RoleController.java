package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.RoleDTO;
import com.schoolmanagement.server.entity.Role;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping("/{id}")
    private ResponseEntity<Object> getRole(@PathVariable("id") Long id) {
        RoleDTO roleDTO = roleService.getRole(id);
        if (roleDTO != null) {
            return ServerResponse.responseEntity(roleDTO);
        }
        return ServerResponse.responseNotFound("Role Not Found .");
    }

    @GetMapping
    private List<RoleDTO> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping
    private ResponseEntity<Object> createRole(@RequestBody @Valid Role role) {
        if (role != null) {
            roleService.createRole(role);
            return ServerResponse.responseMessage("Role created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this role , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateRole(@RequestBody @Valid Role role) {
        if (role != null) {
            roleService.updateRole(role);
            return ServerResponse.responseMessage("Role updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this role , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteRole(@PathVariable("id") Long id) {
        boolean isRoleDeleted = roleService.deleteRole(id);
        if (isRoleDeleted) {
            return ServerResponse.responseMessage("Role deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this role , try again .");
    }
}
