package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Shop;
import com.app.entity.User;
import com.app.repository.ShopRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopService {
	@Autowired
	private ShopRepository repo;
	
	public List<Shop> listAll() {
		return repo.findAll();	
	}
	
	public void save(Shop shop) {
		repo.save(shop);
	}
	
	public Shop get(Integer id) {
		return repo.findById(id).get();
	}
	
	 public void delete(Integer id) {
	    repo.deleteById(id);
	 }
}
