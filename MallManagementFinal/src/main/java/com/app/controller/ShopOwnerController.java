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
import com.app.entity.ShopOwner;
import com.app.repository.ShopOwnerRepository;
import com.app.services.ShopOwnerService;

@RestController
public class ShopOwnerController {
	@Autowired
	ShopOwnerService service;
	@Autowired
	ShopOwnerRepository repo;
	
	@GetMapping("/shopOwner")
	public List <ShopOwner>list() {
		return service.listAll();
	}
	@PostMapping("/shopOwner/add/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody ShopOwner shopOwner) {
		repo.save(shopOwner);
	}
}
