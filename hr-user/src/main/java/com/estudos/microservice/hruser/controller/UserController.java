package com.estudos.microservice.hruser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.microservice.hruser.entity.User;
import com.estudos.microservice.hruser.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		logger.info("SERVIDOR PORTA: " + env.getProperty("local.server.port"));
		User user = repository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}
