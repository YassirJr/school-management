package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.ModuleElementDTO;
import com.schoolmanagement.server.entity.ModuleElement;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.ModuleElementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/module-elements")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ModuleElementController {
    @Autowired
    private ModuleElementService moduleElementService;

    @GetMapping("/{id}")
    private ResponseEntity<Object> getModuleElement(@PathVariable("id") Long id) {
        ModuleElementDTO moduleElementDTO = moduleElementService.getModuleElement(id);
        if (moduleElementDTO != null) {
            return ServerResponse.responseEntity(moduleElementDTO);
        }
        return ServerResponse.responseNotFound("ModuleElement Not Found .");
    }

    @GetMapping
    private List<ModuleElementDTO> getModuleElements() {
        return moduleElementService.getModuleElements();
    }

    @PostMapping
    private ResponseEntity<Object> createModuleElement(@RequestBody @Valid ModuleElement moduleElement) {
        if (moduleElement != null) {
            moduleElementService.createModuleElement(moduleElement);
            return ServerResponse.responseMessage("ModuleElement created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this module Element , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateModuleElement(@RequestBody @Valid ModuleElement moduleElement) {
        if (moduleElement != null) {
            moduleElementService.updateModuleElement(moduleElement);
            return ServerResponse.responseMessage("ModuleElement updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this moduleElement , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteModuleElement(@PathVariable("id") Long id) {
        boolean isModuleElementDeleted = moduleElementService.deleteModuleElement(id);
        if (isModuleElementDeleted) {
            return ServerResponse.responseMessage("ModuleElement deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this module Element , try again .");
    }
}
