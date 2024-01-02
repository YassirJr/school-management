package com.schoolmanagement.server.controller;

import com.schoolmanagement.server.dto.FiliereDTO;
import com.schoolmanagement.server.entity.Filiere;
import com.schoolmanagement.server.response.ServerResponse;
import com.schoolmanagement.server.service.FiliereService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/filieres")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FiliereController {
    @Autowired
    private FiliereService filiereService;


    @GetMapping("/{id}")
    private ResponseEntity<Object> getFiliere(@PathVariable("id") Long id) {
        FiliereDTO filiereDTO = filiereService.getFiliere(id);
        if (filiereDTO != null) {
            return ServerResponse.responseEntity(filiereDTO);
        }
        return ServerResponse.responseNotFound("Filiere Not Found .");
    }

    @GetMapping
    private List<FiliereDTO> getFilieres() {
        return filiereService.getFilieres();
    }

    @PostMapping
    private ResponseEntity<Object> createFiliere(@RequestBody @Valid Filiere filiere) {
        if (filiere != null) {
            filiereService.createFiliere(filiere);
            return ServerResponse.responseMessage("Filiere created successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while creating this filiere , try again .");
    }

    @PutMapping
    private ResponseEntity<Object> updateFiliere(@RequestBody @Valid Filiere filiere) {
        if (filiere != null) {
            filiereService.updateFiliere(filiere);
            return ServerResponse.responseMessage("Filiere updated successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while updating this filiere , try again .");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteFiliere(@PathVariable("id") Long id) {
        boolean isFiliereDeleted = filiereService.deleteFiliere(id);
        if (isFiliereDeleted) {
            return ServerResponse.responseMessage("Filiere deleted Successfully .");
        }
        return ServerResponse.internalServerErrorMessage("Error while deleting this filiere , try again .");
    }
}
