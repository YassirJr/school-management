package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.ModuleDTO;
import com.schoolmanagement.server.entity.Module;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/modules")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ModuleController {
    @Autowired
    private ModuleService moduleService;


    @GetMapping("/{id}")
    private ResponseEntity<Object> getModule(@PathVariable("id") Long id) {
        ModuleDTO moduleDTO = moduleService.getModule(id);
        if (moduleDTO != null) {
            return ServerResponse.responseEntity(moduleDTO);
        }
        return ServerResponse.responseNotFound("Module Not Found .");
    }

    @GetMapping
    private List<ModuleDTO> getModules() {
        return moduleService.getModules();
    }

    @PostMapping
    private ResponseEntity<Object> createModule(@RequestBody @Valid Module module) {
        if (module != null) {
            moduleService.createModule(module);
            return ServerResponse.responseMessage("Module created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this module , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateModule(@RequestBody @Valid Module module) {
        if (module != null) {
            moduleService.updateModule(module);
            return ServerResponse.responseMessage("Module updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this module , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteModule(@PathVariable("id") Long id) {
        boolean isModuleDeleted = moduleService.deleteModule(id);
        if (isModuleDeleted) {
            return ServerResponse.responseMessage("Module deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this module , try again .");
    }
}
