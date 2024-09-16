package com.springbootlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootlearn.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
