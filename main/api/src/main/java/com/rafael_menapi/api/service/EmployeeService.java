package com.rafael_menapi.api.service;

import java.util.List;

import com.rafael_menapi.api.model.Employee;


public interface EmployeeService {  //aqui ficam todos os métodos de serviço relacionados aos verbos get post put e delete ligados ao controller
	List<Employee> getEmployees(int pageNumber, int pageSize);
	
	Employee saveEmployee(Employee employee);
	
	Employee getSingleEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeesByName(String name);
	
	List<Employee> getEmployeesByNameAndLocation(String name, String location);
	
	List<Employee> getEmployeesByKeyword(String name);
	
	List<Employee> getEmployeesByNameOrLocation(String name,String location);
}
