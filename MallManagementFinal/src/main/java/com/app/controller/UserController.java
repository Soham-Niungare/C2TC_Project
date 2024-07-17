package com.app.controller;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	UserRepository repo;
	
	@GetMapping("/user")
	public List <User>list() {
		return service.listAll();
	}
	
	@PostMapping("/user/add/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody User user) {
		repo.save(user);
	}

	
	 @PutMapping("/user/update/{id}")
	 public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id)  {
		 User existUser = repo.findById(id).get();
		 existUser.setName(user.getName());
		 existUser.setType(user.getType());
		 existUser.setPassword(user.getPassword());
		 repo.save(existUser);
		 return new ResponseEntity<User>(HttpStatus.OK);
 
	 }

	 @DeleteMapping("/user/delete/{id}")
	 public void delete(@PathVariable Integer id) //extracting ID from the URL
	 {
		 repo.deleteById(id);
	 }
}
