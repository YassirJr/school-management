package com.schoolmanagement.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 100)
    @NotBlank(message = "First name cannot be null")
    private String firstName;

    @Column(nullable = false , length = 100)
    @NotBlank(message = "Last name cannot be null")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Age cannot be null")
    @Min(value = 10 , message = "Age Must be at least 10")
    private Integer age;

    @Column(name = "role_id" , nullable = false)
    @NotNull(message = "Role must be specified")
    private Long roleId;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false , nullable = false)
    private Role role;
}


