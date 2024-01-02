package com.schoolmanagement.server.repository;

import com.schoolmanagement.server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> { }
