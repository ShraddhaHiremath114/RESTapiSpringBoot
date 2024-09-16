package com.springbootlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootlearn.entity.Employee;


public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void deleteEmployee(int id);
	
	public Employee updateEmployee(int id,Employee employee);
}
