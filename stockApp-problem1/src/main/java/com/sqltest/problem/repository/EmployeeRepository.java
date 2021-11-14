package com.sqltest.problem.repository;

import com.sqltest.problem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByEmployeeId(String id);

}
