package com.sqltest.problem.service;

import com.sqltest.problem.dto.EmployeeDto;
import com.sqltest.problem.entity.Employee;
import com.sqltest.problem.mapper.AppMapper;
import com.sqltest.problem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private final AppMapper appMapper;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<EmployeeDto> getEmployees(){
        return employeeRepository
                .findAll()
                .stream()
                .map(u->appMapper.map(u,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto addEmployee(EmployeeDto employee){

        Employee entity = appMapper.map(employee,Employee.class);
        Employee savedEntity = employeeRepository.save(entity);
        return employee;

    }

    public void deleteEmployee(String employeeId){

        Employee foundEntity = employeeRepository.findByEmployeeId(employeeId);

        if(Objects.nonNull(foundEntity)){
            employeeRepository.delete(foundEntity);
        }


    }


}
