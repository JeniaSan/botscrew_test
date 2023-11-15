package com.example.lectorsdepartment.repository;

import com.example.lectorsdepartment.model.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
