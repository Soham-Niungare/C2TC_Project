package com.app.entity;
import java.util.ArrayList;

import java.util.List;

//import com.app.pojo.Employee;

import jakarta.persistence.*;

@Entity
@Table(name="shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int shopId;
	@Column
	String shopCategory;
	@OneToOne()
	@JoinColumn(name="employee_id")
	Employee shopEmployeeID;
	@Column
	String shopName;
	@Column
	String customer;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ownerId")
	List <ShopOwner> shopOwner = new ArrayList<>();
	@Column
	String leaveStatus;
	@Column
	long id;

	
	
	
	public Shop(String shopCategory, Employee shopEmployeeID, String shopName, String customer,
			List<ShopOwner> shopOwner, String leaveStatus, long id) {
		super();
		this.shopCategory = shopCategory;
		this.shopEmployeeID = shopEmployeeID;
		this.shopName = shopName;
		this.customer = customer;
		this.shopOwner = shopOwner;
		this.leaveStatus = leaveStatus;
		this.id = id;
	}
	public Shop(int shopId, String shopCategory, Employee shopEmployeeID, String shopName, String customer,
			List<ShopOwner> shopOwner, String leaveStatus, long id) {
		super();
		this.shopId = shopId;
		this.shopCategory = shopCategory;
		this.shopEmployeeID = shopEmployeeID;
		this.shopName = shopName;
		this.customer = customer;
		this.shopOwner = shopOwner;
		this.leaveStatus = leaveStatus;
		this.id = id;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	public Employee getShopEmployeeID() {
		return shopEmployeeID;
	}
	public void setShopEmployeeID(Employee shopEmployeeID) {
		this.shopEmployeeID = shopEmployeeID;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public void setShopOwner(List<ShopOwner> shopOwner) {
		this.shopOwner = shopOwner;
	}


	public List<ShopOwner> getShopOwner() {
		return shopOwner;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
