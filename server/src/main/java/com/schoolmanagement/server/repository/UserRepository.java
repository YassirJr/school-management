package com.schoolmanagement.server.repository;
import com.schoolmanagement.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
