package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.ShopOwner;
import com.app.repository.ShopOwnerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopOwnerService {
	@Autowired
	private ShopOwnerRepository repo;
	
	public List<ShopOwner> listAll() {
		return repo.findAll();
	}
	
	public ShopOwner get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
