package com.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.User;
import com.api.repository.UserRepository;

@RestController
public class AuthController {
	private UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@RequestMapping("/test")
	public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
		User test = new User();
		test.setFirstName(name);
		return test;
	}

	@PostMapping("/")
	public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
		userRepository.save(user);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
