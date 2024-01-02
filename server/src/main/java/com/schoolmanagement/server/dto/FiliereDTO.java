package com.schoolmanagement.server.dto;

import com.schoolmanagement.server.entity.Filiere;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiliereDTO {
    private Long id;
    private String name;
    private String department;

    public static FiliereDTO toDTO(Filiere filiere){
        return FiliereDTO.builder()
                .id(filiere.getId())
                .name(filiere.getName())
                .department(filiere.getDepartment().getName())
                .build();
    }


}
