package com.rafael_menapi.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael_menapi.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Métodos personalizados, se necessário
	
	List<Employee> findByName(String name);
}
