package com.example.lectorsdepartment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.lectorsdepartment.model.Lector;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class LectorRepositoryTest {
    public static final BigDecimal SALARY_VALUE = BigDecimal.valueOf(23000.0);
    private static final String TEMPLATE = "van";
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
    private LectorRepository lectorRepository;

    @Test
    @Sql(
            scripts = ADD_LECTOR_SCRIPT,
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
            scripts = DELETE_LECTOR_SCRIPT,
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void testFindAllByTemplate() {
        List<Lector> lectors = lectorRepository.findAllByTemplate(TEMPLATE);
        assertFalse(lectors.isEmpty());
        assertEquals(lectors.size(), 1);
    }

    @Test
    @Sql(
            scripts = {ADD_LECTOR_SCRIPT, ADD_DEPARTMENT_SCRIPT, ADD_RELATION_SCRIPT},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
            scripts = {DELETE_RELATION_SCRIPT, DELETE_DEPARTMENT_SCRIPT, DELETE_LECTOR_SCRIPT},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    public void testFindAverageSalaryByDepartment() {
        BigDecimal averageSalary = lectorRepository.findAverageSalaryByDepartment(DEPARTMENT_NAME);
        assertEquals(averageSalary, SALARY_VALUE);
    }
}
