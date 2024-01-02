package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.ModuleElementDTO;
import com.schoolmanagement.server.entity.ModuleElement;
import com.schoolmanagement.server.exception.MyCustomException;
import com.schoolmanagement.server.repository.ModuleElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleElementService {
    @Autowired
    private ModuleElementRepository moduleElementRepository;

    public ModuleElementDTO getModuleElement(Long id) {
        Optional<ModuleElement> moduleElement = moduleElementRepository.findById(id);
        return moduleElement.map(ModuleElementDTO::toDTO).orElse(null);
    }

    public List<ModuleElementDTO> getModuleElements() {
        List<ModuleElement> moduleElement = moduleElementRepository.findAll();
        return moduleElement.stream().map(ModuleElementDTO::toDTO).collect(Collectors.toList());
    }

    public void createModuleElement(ModuleElement moduleElement) {
        try {
            moduleElementRepository.save(moduleElement);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This filiere is currently in our record , try another name .");
            } else
                throw new MyCustomException("This module id not in our record , please try to choose a valid moduleElement");
        }
    }

    public void updateModuleElement(ModuleElement moduleElement) {
        try {
            moduleElementRepository.save(moduleElement);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This module element is currently in our record , try another name .");
            } else
                throw new MyCustomException("This module id not in our record , please try to choose a valid moduleElement");
        }
    }

    public boolean deleteModuleElement(Long id) {

        Optional<ModuleElement> moduleElement = moduleElementRepository.findById(id);
        if (moduleElement.isPresent()) {
            moduleElementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
