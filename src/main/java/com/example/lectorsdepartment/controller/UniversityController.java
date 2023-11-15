package com.example.lectorsdepartment.controller;

import com.example.lectorsdepartment.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @ShellMethod(key = "Who is head of department")
    public String getHeadOfDepartment(@ShellOption String departmentName) {
        return universityService.getHeadOfDepartment(departmentName);
    }

    @ShellMethod(key = "Show statistics for")
    public String getStatistics(@ShellOption String departmentName) {
        return universityService.getStatistics(departmentName);
    }

    @ShellMethod(key = "Show the average salary for the department")
    public String getAverageSalary(@ShellOption String departmentName) {
        return universityService.getAverageSalary(departmentName);
    }

    @ShellMethod(key = "Show count of employee for")
    public String getEmployeeCount(@ShellOption String departmentName) {
        return universityService.getEmployeeCount(departmentName);
    }

    @ShellMethod(key = "Global search by")
    public String searchByTemplate(@ShellOption String template) {
        return universityService.searchByTemplate(template);
    }

}
