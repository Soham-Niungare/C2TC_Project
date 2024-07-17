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
@Table(name="shop_owner")
public class ShopOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ownerId;
	@Column
	String name;
	@Column
	LocalDate dob;
	@Column
	String address;
	@ManyToOne
	@JoinColumn(name="shopId")
	Shop shop_id;
	
	
	public ShopOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShopOwner(String name, LocalDate dob, String address, Shop shop_id) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.shop_id = shop_id;
	}

	public ShopOwner(int ownerId, String name, LocalDate dob, String address, Shop shop_id) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.shop_id = shop_id;
	}

	public int getId() {
		return ownerId;
	}
	public void setId(int id) {
		this.ownerId = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Shop getShop_id() {
		return shop_id;
	}
	public void setShop_id(Shop shop_id) {
		this.shop_id = shop_id;
	}
	
}
