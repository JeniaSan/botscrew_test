package com.example.lectorsdepartment.repository;

import com.example.lectorsdepartment.model.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("FROM Department d "
            + "JOIN FETCH d.head JOIN FETCH d.lectors WHERE d.name = :departmentName")
    Optional<Department> findByName(String departmentName);
}
