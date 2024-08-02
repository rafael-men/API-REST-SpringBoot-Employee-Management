package com.rafael_menapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael_menapi.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Métodos personalizados, se necessário
}
