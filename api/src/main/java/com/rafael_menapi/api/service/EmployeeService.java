package com.rafael_menapi.api.service;

import java.util.List;

import com.rafael_menapi.api.model.Employee;


public interface EmployeeService {
	List<Employee> getEmployees();
	
	Employee saveEmployee(Employee employee);
}
