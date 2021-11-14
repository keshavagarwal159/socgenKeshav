package com.sqltest.problem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectId = UUID.randomUUID().toString();
    private String name;
    private Integer budget;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Employee> employees;

}
