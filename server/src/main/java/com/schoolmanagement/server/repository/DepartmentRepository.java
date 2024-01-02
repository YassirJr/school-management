package com.schoolmanagement.server.repository;
import com.schoolmanagement.server.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Long> {
    public Department findByChefId(Long chef_id);
}
