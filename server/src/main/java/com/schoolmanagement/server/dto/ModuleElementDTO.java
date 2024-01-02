package com.schoolmanagement.server.dto;

import com.schoolmanagement.server.entity.ModuleElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleElementDTO {
    private Long id;
    private String name;
    private String module;

    public static ModuleElementDTO toDTO(ModuleElement moduleElement){
        return ModuleElementDTO.builder()
                .id(moduleElement.getId())
                .name(moduleElement.getName())
                .module(moduleElement.getModule().getName())
                .build();
    }


}
