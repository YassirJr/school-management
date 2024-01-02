package com.schoolmanagement.server.dto;


import com.schoolmanagement.server.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;


    public static RoleDTO toDTO(Role role){
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName().toString())
                .build();
    }
}
