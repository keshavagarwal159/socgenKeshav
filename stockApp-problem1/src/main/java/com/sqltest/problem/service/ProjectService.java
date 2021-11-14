package com.sqltest.problem.service;

import com.sqltest.problem.dto.EmployeeDto;
import com.sqltest.problem.entity.Employee;
import com.sqltest.problem.entity.Project;
import com.sqltest.problem.mapper.AppMapper;
import com.sqltest.problem.dto.ProjectDto;
import com.sqltest.problem.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private final AppMapper appMapper;

    public List<ProjectDto> getProjects(){
        return projectRepository
                .findAll()
                .stream()
                .map(u->appMapper.map(u,ProjectDto.class))
                .collect(Collectors.toList());
    }

    public ProjectDto addProject(ProjectDto project){

        Project entity = appMapper.map(project,Project.class);
        Project savedEntity = projectRepository.save(entity);
        return project;

    }

    public void deleteProject(String projectId){

        Project foundEntity = projectRepository.findByProjectId(projectId);

        if(Objects.nonNull(foundEntity)){
            projectRepository.delete(foundEntity);
        }


    }

    public ProjectDto getProjectById(String id){
        Project entity =  projectRepository.findByProjectId(id);
        ProjectDto foundProject = appMapper.map(entity,ProjectDto.class);
        return foundProject;
    }

    public ProjectDto getProjectByName(String name){
        Project entity =  projectRepository.findByName(name);
        ProjectDto foundProject = appMapper.map(entity,ProjectDto.class);
        return foundProject;
    }

    public Set<EmployeeDto> getUsersByProjectName(String projectName) {

        Project entity = projectRepository.findByName(projectName);

        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();


        for(Employee e: entity.getEmployees()){
            employeeDtos.add(appMapper.map(e,EmployeeDto.class));
        }

        return employeeDtos.stream().collect(Collectors.toSet());

    }

    public int getProjectCostByName(String projectName){

        int cost = 0;
        for (EmployeeDto e: this.getUsersByProjectName(projectName)){

            cost = cost + e.getSalary();

        }
        return cost;

    }

    public EmployeeDto addEmployeeToProject(String projectId, EmployeeDto employee){

        Project project = projectRepository.findByProjectId(projectId);
        project.getEmployees().add(appMapper.map(employee,Employee.class));
        projectRepository.save(project);
        return employee;

    }

}
