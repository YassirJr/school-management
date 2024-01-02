package com.schoolmanagement.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "module_elements")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false , unique = true)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "module_id")
    @NotNull(message = "Module must be specified")
    private Long moduleId;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;

}
