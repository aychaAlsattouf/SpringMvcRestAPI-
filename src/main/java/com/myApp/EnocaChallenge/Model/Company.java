package com.myApp.EnocaChallenge.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "name" , columnDefinition="text")
	@NotBlank(message = "name may not be blank") 
    private String name;
	
	@Column(name = "address", columnDefinition="text")
	@NotBlank(message = "address may not be blank") 
    private String address;
	
	@Column(name = "telephone",columnDefinition="text")
	@NotBlank(message = "telephone may not be blank") 
    private String telephone;
	
	@Column(name = "description", columnDefinition="text")
	@NotBlank(message = "description may not be blank") 
    private String description;
	
	@OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "project_id")
	@JsonManagedReference
    private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees= new ArrayList<>();
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

	public Company(String name, String address, String telephone, String desc) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.description = desc;
	}

	public Company(int id, String name, String address, String telephone, String desc, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.description = desc;
		this.employees = employees;
	}

	public Company() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	

}
