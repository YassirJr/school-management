package com.schoolmanagement.server.entity;

import com.schoolmanagement.server.enums.USER_ROLE_VALUES;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "roles")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "role name must be specified")
    private USER_ROLE_VALUES name;
}
