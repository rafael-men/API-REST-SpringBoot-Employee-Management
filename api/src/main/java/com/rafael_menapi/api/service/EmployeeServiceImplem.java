package com.rafael_menapi.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael_menapi.api.model.Employee;
import com.rafael_menapi.api.repository.EmployeeRepository;


@Service
public class EmployeeServiceImplem implements EmployeeService { //implementação dos métodos de serviço
	
	private static List<Employee> list = new ArrayList<>(); //lista de usuários
	
	@Autowired
	private EmployeeRepository eRepository;

	@Override //método de implementação do serviço
	public List<Employee> getEmployees() {
		return eRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional <Employee> employee = eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee not found :(");
	}

	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override //escolhe empregados pelo nome
	public List<Employee> getEmployeesByName(String Name) {
		return eRepository.findByName(Name);
	}
	
}
