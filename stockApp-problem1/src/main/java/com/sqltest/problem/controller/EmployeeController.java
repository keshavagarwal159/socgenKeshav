package com.sqltest.problem.controller;


import com.sqltest.problem.dto.EmployeeDto;
import com.sqltest.problem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody EmployeeDto employee){
        return new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
