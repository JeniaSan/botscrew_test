package com.example.lectorsdepartment.controller;

import com.example.lectorsdepartment.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    public String getHeadOfDepartment(String departmentName) {
        return universityService.getHeadOfDepartment(departmentName);
    }

    public String getStatistics(String departmentName) {
        return universityService.getStatistics(departmentName);
    }

    public String getAverageSalary(String departmentName) {
        return universityService.getAverageSalary(departmentName);
    }

    public String getEmployeeCount(String departmentName) {
        return universityService.getEmployeeCount(departmentName);
    }

    public String searchByTemplate(String template) {
        return universityService.searchByTemplate(template);
    }

}
