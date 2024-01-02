package com.schoolmanagement.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Table(
        name = "departments"
)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name" , nullable = false , unique = true)
    @NotNull(message = "Name must be not null")
    private String name;

    @Column(name = "user_id" , nullable = true)
//    @NotNull(message = "Chef must be specified")
    private Long chefId;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User chef;

    @OneToMany(mappedBy = "department") // cascade = CascadeType.REMOVE, orphanRemoval = true
    private List<Filiere> filieres;
}
