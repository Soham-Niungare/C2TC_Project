package com.app.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employeeId;
	@Column
	String name;
	@Column
	LocalDate dob;
	@Column
	float salary;
	@Column
	String address;
	@Column
	String designation;
	@ManyToOne
	@JoinColumn(name="shopId")
	Shop shop_id;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, LocalDate dob, float salary, String address, String designation, Shop shop_id) {
		super();
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
		this.shop_id = shop_id;
	}
	
	public Employee(int id, String name, LocalDate dob, float salary, String address, String designation,
			Shop shop_id) {
		super();
		this.employeeId = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
		this.shop_id = shop_id;
	}

	public int getId() {
		return employeeId;
	}
	public void setId(int id) {
		this.employeeId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Shop getShop_id() {
		return shop_id;
	}
	public void setShop_id(Shop shop_id) {
		this.shop_id = shop_id;
	}
	
}
