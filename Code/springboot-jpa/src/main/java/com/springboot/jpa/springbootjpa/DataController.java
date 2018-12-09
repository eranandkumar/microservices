package com.springboot.jpa.springbootjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.springbootjpa.entity.User;
import com.springboot.jpa.springbootjpa.proxy.UserRepository;
import com.springboot.jpa.springbootjpa.service.UserDAOService;

@RestController
public class DataController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserDAOService userDaoService;

	@GetMapping("/helloFromJpa")
	public String hello() {
		return "HELLO FROM JAP";
	}
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	@PostMapping("/users")
	public String persistUser(@RequestBody User user) {
		 Long userId;
		userId = userDaoService.saveUser(user);
		
		return String.format("User is same with Id %s", userId);
	}
}
