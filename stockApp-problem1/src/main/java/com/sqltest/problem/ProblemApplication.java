package com.sqltest.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackages = {"com.sqltest.problem.mapper","com.sqltest.problem.controller","com.sqltest.problem.service","com.sqltest.problem.repository"})
public class ProblemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProblemApplication.class, args);
	}

}
