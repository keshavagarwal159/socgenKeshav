package com.sqltest.problem.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDto {
    private String id;
    private String name;
    private int budget;
    private Set<EmployeeDto> employees;
}
