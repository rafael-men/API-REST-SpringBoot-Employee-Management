package com.rafael_menapi.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael_menapi.api.model.Employee;
import com.rafael_menapi.api.repository.EmployeeRepository;


@Service
public class EmployeeServiceImplem implements EmployeeService {
	
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
	
}
