package com.schoolmanagement.server.dto;

import com.schoolmanagement.server.entity.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private Long id;

    private String name;

    private Integer nbrElements ;

    private String filiere;

    public static ModuleDTO toDTO(Module module){
        return ModuleDTO.builder()
                .id(module.getId())
                .name(module.getName())
                .nbrElements(module.getNbrElements())
                .filiere(module.getFiliere().getName())
                .build();
    }


}
