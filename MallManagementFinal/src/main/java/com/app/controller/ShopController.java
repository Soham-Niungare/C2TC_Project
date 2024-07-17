package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
