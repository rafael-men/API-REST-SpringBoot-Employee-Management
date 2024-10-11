package com.rafael_menapi.api.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafael_menapi.api.model.Employee;
import com.rafael_menapi.api.service.EmployeeService;


@Tag(name = "Employee Endpoints")
@RestController
@RequestMapping("/apilearning/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @Value("${app.name}")
    private String appname;

    @Value("${app.version}")
    private String appversion;

    @Operation(summary = "Get Employees")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(
        @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @Operation(summary = "Get Employees By Id")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new Employee")
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Employees")
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(eService.updateEmployee(employee), HttpStatus.OK);
    }

    @Operation(summary = "Delete Employees")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        eService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Filter Employees by Name")
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @Operation(summary = "Filter Employees by Name and Location")
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(
        @RequestParam String name,
        @RequestParam String location) {
        return new ResponseEntity<>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @Operation(summary = "Filter Employees By Keyword")
    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String keyword) {
        return new ResponseEntity<>(eService.getEmployeesByKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/employees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(
        @PathVariable String name,
        @PathVariable String location) {
        return new ResponseEntity<>(eService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
    }
}
