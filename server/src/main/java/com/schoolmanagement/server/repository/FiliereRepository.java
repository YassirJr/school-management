package com.schoolmanagement.server.repository;

import com.schoolmanagement.server.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    public Optional<Filiere> findByDepartmentId(Long department_id);
}
