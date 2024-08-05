package com.rafael_menapi.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rafael_menapi.api.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndLocation(String name, String location);
    List<Employee> findByNameContaining(String keyword, Sort sort);
    
    @Query("FROM Employee WHERE name =: name")
    List<Employee> getEmployeesByNameAndLocation(@Param("name") String abc,String location);
}
