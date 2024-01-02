package com.schoolmanagement.server.service;

import com.schoolmanagement.server.dto.ModuleDTO;
import com.schoolmanagement.server.entity.Module;
import com.schoolmanagement.server.exception.MyCustomException;
import com.schoolmanagement.server.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    public ModuleDTO getModule(Long id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.map(ModuleDTO::toDTO).orElse(null);
    }

    public List<ModuleDTO> getModules() {
        List<Module> modules = moduleRepository.findAll();
        return modules.stream().map(ModuleDTO::toDTO).collect(Collectors.toList());
    }

    public void createModule(Module module) {
        try {
            moduleRepository.save(module);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This module is currently in our record , try another name .");
            } else
                throw new MyCustomException("This filiere id not in our record , please try to choose a valid module");
        }
    }

    public void updateModule(Module module) {
        try {
            moduleRepository.save(module);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                throw new MyCustomException("This module is currently in our record , try another name .");
            } else
                throw new MyCustomException("This filiere id not in our record , please try to choose a valid module");
        }
    }

    public boolean deleteModule(Long id) {
        try {
            Optional<Module> module = moduleRepository.findById(id);
            if (module.isPresent()) {
                moduleRepository.deleteById(id);
                return true;
            }
        } catch (DataIntegrityViolationException e) {
            throw new MyCustomException("The module is assigned to a element ");
        }
        return false;
    }
}
