package com.sqltest.problem.controller;


import com.sqltest.problem.dto.EmployeeDto;
import com.sqltest.problem.dto.ProjectDto;
import com.sqltest.problem.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("/projects")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDto> getProjects(){
        return projectService.getProjects();
    }

    @PostMapping
    public ResponseEntity addProject(@RequestBody ProjectDto project){
        return new ResponseEntity(projectService.addProject(project), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable String id){
        projectService.deleteProject(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/id/{id}")
    public ProjectDto findProjectByProjectId(@PathVariable String id){
        return projectService.getProjectById(id);
    }

    @GetMapping("/name/{name}")
    public ProjectDto findProjectByName(@PathVariable String name){
        return projectService.getProjectByName(name);
    }

    @GetMapping("/users/{name}")
    public Set<EmployeeDto> findUsersByProjectName(@PathVariable String name){
        return projectService.getUsersByProjectName(name);
    }

    @GetMapping("/cost/{name}")
    public int findProjectCostByName(@PathVariable String name){
        return projectService.getProjectCostByName(name);
    }

    @GetMapping("/profit/{name}/{revenue}")
    public int findProjectProfitByNameAndRevenue(@PathVariable String name, @PathVariable int revenue){
        return revenue - projectService.getProjectCostByName(name);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity addEmployeeToProject(@RequestBody EmployeeDto employee, @PathVariable String id){

        projectService.addEmployeeToProject(id,employee);
        return new ResponseEntity(employee,HttpStatus.CREATED);

    }
}
