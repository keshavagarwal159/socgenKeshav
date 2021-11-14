package com.sqltest.problem.repository;

import com.sqltest.problem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

    Project findByProjectId(String id);
    Project findByName(String name);

}
