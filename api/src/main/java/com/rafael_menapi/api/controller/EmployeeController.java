package com.rafael_menapi.api.controller;

import java.util.List;

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

import jakarta.validation.Valid;

@RestController //Controller + RequestBody
@RequestMapping("/apilearning/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@Value("${app.name}")
	private String appname;
	
	@Value("${app.version}")
	private String appversion;

    @GetMapping("/employees") //Método Get
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>> (eService.getEmployees(),HttpStatus.OK);
    }
    
    @GetMapping("/employees/{id}") //Chama os Empregados por id usando Método Get
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
    	return new ResponseEntity<Employee> (eService.getSingleEmployee(id),HttpStatus.OK);
    }
    
    @PostMapping("/employees") //salva os dados
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee> (eService.saveEmployee(employee),HttpStatus.CREATED);
    }
    
    @PutMapping("/employees/{id}") //atualiza os dados existentes
    public ResponseEntity<Employee> updateEmployee (@PathVariable Long id,@RequestBody Employee employee) {
    	employee.setId(id);
    	return new ResponseEntity<Employee> (eService.updateEmployee(employee),HttpStatus.OK);
    }
    
    @DeleteMapping("/employees") //deleta um usuário
    public ResponseEntity<HttpStatus> deleteEmployee (@RequestParam("id") Long id) {
       return new ResponseEntity<HttpStatus> (HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName( @RequestParam String Name) {
    	return new ResponseEntity<List<Employee>> (eService.getEmployeesByName(Name),HttpStatus.OK);
    }
    
}
