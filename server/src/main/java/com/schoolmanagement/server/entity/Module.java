package com.schoolmanagement.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "modules")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false , unique = true)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "nbr_elements" , nullable = false )
    @NotNull(message = "Number of elements must be specified")
    private Integer nbrElements ;

    @Column(name = "filiere_id")
    @NotNull(message = "Filiere must be specified")
    private Long filiereId;

    @ManyToOne
    @JoinColumn(name = "filiere_id", insertable = false, updatable = false)
    private Filiere filiere;


}
