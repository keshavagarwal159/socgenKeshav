package com.sqltest.problem.mapper;

import com.sqltest.problem.dto.EmployeeDto;
import com.sqltest.problem.dto.ProjectDto;
import com.sqltest.problem.entity.Employee;
import com.sqltest.problem.entity.Project;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class AppMapper extends ConfigurableMapper {


    @Override
    protected void configure(MapperFactory factory){
        factory.registerClassMap(factory.classMap(Employee.class, EmployeeDto.class)
                .fieldAToB("employeeId","id")
                .byDefault());

        factory.registerClassMap(factory.classMap(Project.class, ProjectDto.class)
                .fieldAToB("projectId","id")
                .byDefault());


    }

}
