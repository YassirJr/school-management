package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.DepartmentDTO;
import com.schoolmanagement.server.entity.Department;
import com.schoolmanagement.server.exception.MyCustomException;
import com.schoolmanagement.server.repository.DepartmentRepository;
import com.schoolmanagement.server.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    public DepartmentDTO getDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.map(DepartmentDTO::toDTO).orElse(null);
    }

    public List<DepartmentDTO> getDepartments() {
        List<Department> department = departmentRepository.findAll();
        return department.stream().map(DepartmentDTO::toDTO).collect(Collectors.toList());
    }

    public void createDepartment(Department department) {
        try {
            departmentRepository.save(department);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This filiere is currently in our record , try another name .");
            } else
                throw new MyCustomException("This department id not in our record , please try to choose a valid department");
        }
    }

    public void updateDepartment(Department department) {
        try {
            departmentRepository.save(department);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This filiere is currently in our record , try another name .");
            } else
                throw new MyCustomException("This department id not in our record , please try to choose a valid department");
        }
    }

    public boolean deleteDepartment(Long id) {
        try {
            Optional<Department> department = departmentRepository.findById(id);
            if (department.isPresent()) {
                departmentRepository.deleteById(id);
                return true;
            }
        } catch (DataIntegrityViolationException e) {
            throw new MyCustomException("The departement is assigned to filiere .");
        }
        return false;
    }
}
