package com.example.lectorsdepartment.repository;

import com.example.lectorsdepartment.model.Lector;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("FROM Lector l WHERE l.firstName LIKE %:template% OR l.lastName LIKE %:template%")
    List<Lector> findAllByTemplate(String template);

    @Query("SELECT AVG(l.salary) FROM Lector l JOIN l.departments d "
            + "WHERE d.name = :departmentName")
    BigDecimal findAverageSalaryByDepartment(String departmentName);
}
