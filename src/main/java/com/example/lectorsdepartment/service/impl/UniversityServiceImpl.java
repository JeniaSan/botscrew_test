package com.example.lectorsdepartment.service.impl;

import com.example.lectorsdepartment.exception.EntityNotFoundException;
import com.example.lectorsdepartment.model.Department;
import com.example.lectorsdepartment.model.Lector;
import com.example.lectorsdepartment.repository.DepartmentRepository;
import com.example.lectorsdepartment.repository.LectorRepository;
import com.example.lectorsdepartment.service.UniversityService;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private static final String DEPARTMENT_NOT_FOUND_MESSAGE = "Can't find department by name: %s";
    private static final String DEPARTMENT_HEAD_RESPONSE = "Head of %s department is %s\n";
    private static final String STATISTIC_RESPONSE = """
            assistants - %s
            associate professors - %s
            professors - %s
            """;
    private static final String AVERAGE_SALARY_RESPONSE = "The average salary of %s is %s";
    private static final String COMMA_JOIN = ", ";
    private static final String SPACE_JOIN = " ";
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public String getHeadOfDepartment(String departmentName) {
        Lector head = getDepartment(departmentName)
                .getHead();
        return String.format(DEPARTMENT_HEAD_RESPONSE, departmentName,
                head.getFirstName() + SPACE_JOIN + head.getLastName());
    }

    @Override
    public String getStatistics(String departmentName) {
        Department department = getDepartment(departmentName);
        long assistantsCount = countLectorsByDegree(department, Lector.Degree.ASSISTANT);
        long associateProfessorsCount =
                countLectorsByDegree(department, Lector.Degree.ASSOCIATE_PROFESSOR);
        long professorsCount = countLectorsByDegree(department, Lector.Degree.PROFESSOR);
        return String.format(
                STATISTIC_RESPONSE, assistantsCount, associateProfessorsCount, professorsCount);
    }

    @Override
    public String getAverageSalary(String departmentName) {
        BigDecimal averageSalary = lectorRepository.findAverageSalaryByDepartment(departmentName);
        return String.format(AVERAGE_SALARY_RESPONSE, departmentName, averageSalary);
    }

    @Override
    public String getEmployeeCount(String departmentName) {
        return String.valueOf(
                getDepartment(departmentName)
                        .getLectors()
                        .size());
    }

    @Override
    public String searchByTemplate(String template) {
        return lectorRepository.findAllByTemplate(template).stream()
                .map(l -> l.getFirstName() + SPACE_JOIN + l.getLastName())
                .collect(Collectors.joining(COMMA_JOIN));
    }

    private Department getDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(DEPARTMENT_NOT_FOUND_MESSAGE, departmentName)));
    }

    private long countLectorsByDegree(Department department, Lector.Degree degree) {
        return department.getLectors().stream()
                .filter(l -> l.getDegree().equals(degree))
                .count();
    }
}
