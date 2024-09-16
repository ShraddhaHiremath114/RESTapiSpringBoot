package com.springbootlearn.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootlearn.entity.Employee;
import com.springbootlearn.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee empDB=employeeRepo.findById(id).get();
		if(Objects.nonNull(employee.getEmpname()) && !"".equalsIgnoreCase(employee.getEmpname())){
			empDB.setEmpname(employee.getEmpname());
		}
		if(Objects.nonNull(employee.getSalary()) ) {
			empDB.setSalary(employee.getSalary());
		}
		if(Objects.nonNull(employee.getAge())) {
			empDB.setAge(employee.getAge());
		}
		if(Objects.nonNull(employee.getCity()) && "".equalsIgnoreCase(employee.getCity())) {
			empDB.setCity(employee.getCity());
		}
		
		return employeeRepo.save(empDB);
	}
	
	
}
