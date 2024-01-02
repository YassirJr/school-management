package com.schoolmanagement.server.repository;

import com.schoolmanagement.server.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
