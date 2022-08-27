package com.example.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping
	private ResponseEntity<User> create_user(@RequestBody User user){
		
		List<User> userData = userService.findByEmail(user.getEmail());
		if (userData.size() > 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			User temporal = userService.create(user);
			try {
				return ResponseEntity.created(new URI("/api/user/"+temporal.getId())).body(temporal);
			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping
	private ResponseEntity<List<User>> listAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Void> deleteUser(@PathVariable ("id") Integer id){
		Optional<User> userData = userService.findById(id);
		if (userData.isPresent()) {
			User _user = userData.get();
			userService.delete(_user);
			return ResponseEntity.ok().build();
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<User>> findByUser(@PathVariable ("id") Integer id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PutMapping(value = "{id}")
	private ResponseEntity<Optional<User>> updateUser(@PathVariable ("id") Integer id, @RequestBody User user){
		Optional<User> userData = userService.findById(id);
		 if (userData.isPresent()) {
			 User _user = userData.get();
			 _user.setEmail(user.getEmail());
			 _user.setIsActive(user.getIsActive());
			 _user.setLastLogin(user.getLastLogin());
			 _user.setName(user.getName());
			 _user.setPassword(user.getPassword());
			 _user.setToken(user.getToken());
			 _user.setUpdateAt(user.getUpdateAt());
			 _user.setPhones(user.getPhones());
			 userService.create(user);
			 return ResponseEntity.ok().build();
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
	}

}
