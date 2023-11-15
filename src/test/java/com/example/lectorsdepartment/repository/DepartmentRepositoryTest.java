package com.example.lectorsdepartment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.lectorsdepartment.model.Department;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class DepartmentRepositoryTest {
    private static final String DEPARTMENT_NAME = "FICT";
    private static final String ADD_DEPARTMENT_SCRIPT =
            "classpath:database/department/add-fict-to-department-table.sql";
    private static final String ADD_LECTOR_SCRIPT =
            "classpath:database/lector/add-ivan-to-lector-table.sql";
    private static final String ADD_RELATION_SCRIPT =
            "classpath:database/department_lector/add-relation-to-department_lector-table.sql";
    private static final String DELETE_DEPARTMENT_SCRIPT =
            "classpath:database/department/delete-from-department-table.sql";
    private static final String DELETE_LECTOR_SCRIPT =
            "classpath:database/lector/delete-from-lector-table.sql";
    private static final String DELETE_RELATION_SCRIPT = "classpath"
            + ":database/department_lector/delete-relation-from-department_lector-table.sql";
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Sql(
            scripts = {ADD_LECTOR_SCRIPT, ADD_DEPARTMENT_SCRIPT, ADD_RELATION_SCRIPT},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
            scripts = {DELETE_RELATION_SCRIPT, DELETE_DEPARTMENT_SCRIPT, DELETE_LECTOR_SCRIPT},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    @DisplayName("Get department by name")
    public void findByName_returnsExpectedDepartment() {
        Optional<Department> departmentOptional = departmentRepository.findByName(DEPARTMENT_NAME);
        assertTrue(departmentOptional.isPresent());
        Department department = departmentOptional.get();
        assertEquals(DEPARTMENT_NAME, department.getName());
        assertNotNull(department.getHead());
        assertFalse(department.getLectors().isEmpty());
    }
}
