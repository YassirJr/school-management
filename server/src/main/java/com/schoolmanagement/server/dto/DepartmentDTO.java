package com.schoolmanagement.server.dto;

import com.schoolmanagement.server.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private Map chef;
    private List<FiliereDTO> filieres;


    public static DepartmentDTO toDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .chef(
                        Map.of(
                                "firstName", department.getChef() != null ? department.getChef().getFirstName() : "Unknown" ,
                                "lastName", department.getChef() != null ? department.getChef().getLastName() : "Unknown",
                                "id", department.getChef() != null ? department.getChef().getId() : "Unknown"
                        ))
                .filieres(department.getFilieres()
                        .stream()
                        .map(FiliereDTO::toDTO)
                        .toList())
                .build();
    }

}
