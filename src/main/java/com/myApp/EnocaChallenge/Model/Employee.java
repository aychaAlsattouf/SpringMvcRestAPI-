package com.myApp.EnocaChallenge.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
    private int id;
	
	//@Column(name = "first_name" ,nullable=false )
	//

	@Column(name = "first_name",nullable=false ,length = 5 )
    private String first_name;
	
	@Column(name = "last_name",nullable=false ,length = 50 )
    private String last_name;

	@Column(name = "address",nullable=false ,length = 50 )
    private String address;
	
	@Column(name = "telephone",nullable=false ,length = 11 )
	@NotNull
    private String telephone;
	
	@Column(name = "role",nullable=false )
	@NotBlank(message = "role may not be blank") 
    private String role;
	
	
	@ManyToOne
    @JsonBackReference 
    @JoinColumn(name = "project_id",referencedColumnName = "id" )
    private Company company;
	
	public Employee( String first_name, String last_name, String address, String telephone, String role) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.telephone = telephone;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", telephone=" + telephone + ", role=" + role + ", company=" + company + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Employee() {
		super();
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
}