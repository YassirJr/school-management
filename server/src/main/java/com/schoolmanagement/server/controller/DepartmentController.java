package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.DepartmentDTO;
import com.schoolmanagement.server.entity.Department;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    private ResponseEntity<Object> getDepartment(@PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.getDepartment(id);
        if (departmentDTO != null) {
            return ServerResponse.responseEntity(departmentDTO);
        }
        return ServerResponse.responseNotFound("Department Not Found .");
    }

    @GetMapping
    private List<DepartmentDTO> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping
    private ResponseEntity<Object> createDepartment(@RequestBody @Valid Department department) {
        if (department != null) {
            departmentService.createDepartment(department);
            return ServerResponse.responseMessage("Department created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this department , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateDepartment(@RequestBody @Valid Department department) {
        if (department != null) {
            departmentService.updateDepartment(department);
            return ServerResponse.responseMessage("Department updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this department , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteDepartment(@PathVariable("id") Long id) {
        boolean isDepartmentDeleted = departmentService.deleteDepartment(id);
        if (isDepartmentDeleted) {
            return ServerResponse.responseMessage("Department deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this department , try again .");
    }
}
