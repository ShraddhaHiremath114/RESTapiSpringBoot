package com.springbootlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearn.entity.Employee;
import com.springbootlearn.repository.EmployeeRepo;
import com.springbootlearn.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Employee REST API Demo";
	}
	
	@PostMapping("/employees")
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return this.employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
}
