package com.schoolmanagement.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "filieres")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true , length = 50)
    @NotNull(message = "Name must be not null")
    private String name;

    @Column(name = "department_id")
    @NotNull(message = "Department must be specified")
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;
}

