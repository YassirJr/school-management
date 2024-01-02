package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.FiliereDTO;
import com.schoolmanagement.server.entity.Filiere;
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
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<FiliereDTO> getFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        return filieres.stream().map(FiliereDTO::toDTO)
                .collect(Collectors.toList());
    }

    public FiliereDTO getFiliere(Long id) {
        Optional<Filiere> filiere = filiereRepository.findById(id);
        return filiere.map(FiliereDTO::toDTO).orElse(null);
    }

    public void createFiliere(Filiere filiere) {
        try {
            filiereRepository.save(filiere);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This filiere is currently in our record , try another name .");
            } else
                throw new MyCustomException("This department id not in our record , please try to choose a valid department");
        }
    }

    public void updateFiliere(Filiere filiere) {
        try {
            filiereRepository.save(filiere);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This filiere is currently in our record , try another name .");
            } else
                throw new MyCustomException("This department id not in our record , please try to choose a valid department");
        }
    }

    public boolean deleteFiliere(Long id) {
        try {
            Optional<Filiere> filiere = filiereRepository.findById(id);
            if (filiere.isPresent()) {
                filiereRepository.deleteById(id);
                return true;
            }
        } catch (DataIntegrityViolationException e) {
            throw new MyCustomException("The filiere is assigned to a element ");
        }
        return false;
    }
}
