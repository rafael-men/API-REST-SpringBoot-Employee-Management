package com.rafael_menapi.api.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public List<Employee> getEmployees() {
        return eService.getEmployees();
    }
    
    @GetMapping("/employees/{id}") //Chama os Empregados por id usando Método Get
    public String getEmployee(@PathVariable("id") Long id) {
    	return "Fetching employee details";
    }
    
    @PostMapping("/employees") //salva os dados
    public Employee saveEmployee(@RequestBody Employee employee) {
        return eService.saveEmployee(employee);  
    }
    
    @PutMapping("/employees/{id}") //atualiza os dados existentes
    public Employee updateEmployee (@PathVariable Long id,@RequestBody Employee employee) {
    	return employee;
    }
    
    @DeleteMapping("/employees") //deleta um usuário
    public String deleteEmployee (@RequestParam("id") Long id) {
    	return "Deleting employee details for id"+id;
    }
}
