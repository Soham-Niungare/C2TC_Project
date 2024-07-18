package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Shop;
import com.app.entity.User;
import com.app.repository.ShopRepository;
import com.app.services.ShopService;

@RestController
public class ShopController {
	@Autowired
	ShopService service;
	@Autowired
	ShopRepository repo;
	
	@GetMapping("/shop")
	public List <Shop>list() {
		return service.listAll();
	}
	
	@PostMapping("/shop/add/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody Shop shop) {
		repo.save(shop);
	}
	
	 @PutMapping("/shop/update/{id}")
	 public ResponseEntity<User> update(@RequestBody Shop shop, @PathVariable Integer id)  {
		 Shop existShop = repo.findById(id).get();
		 existShop.setShopCategory(shop.getShopCategory());
		 existShop.setShopEmployeeID(shop.getShopEmployeeID());
		 existShop.setShopName(shop.getShopName());
		 existShop.setCustomer(shop.getCustomer());
		 existShop.setShopOwner(shop.getShopOwner());
		 existShop.setLeaveStatus(shop.getLeaveStatus());
		 existShop.setId(shop.getId());
		 repo.save(existShop);
		 return new ResponseEntity<User>(HttpStatus.OK);

	 }
	 
	 @DeleteMapping("/shop/delete/{id}")
	 public void delete(@PathVariable Integer id) //extracting ID from the URL
	 {
		 repo.deleteById(id);
	 }
	 
	
	
}
