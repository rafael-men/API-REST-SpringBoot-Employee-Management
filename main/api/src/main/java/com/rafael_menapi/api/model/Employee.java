package com.rafael_menapi.api.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.ToString;


@ToString
@Entity
@Table(name="tb_employees")
public class Employee {     //modelo corresponde a uma entidade no banco de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JsonProperty("Full_Name")
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private Long age;
	
	@Column(name="location")
	private String location;
	
	@Column(name="email")
	@Email(message="Please enter a valid email")
	private String email;
	
	@Column(name="department")
	private String department;
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(location, age, department, email, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(location, other.location) && Objects.equals(age, other.age)
				&& Objects.equals(department, other.department) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	
	
}
