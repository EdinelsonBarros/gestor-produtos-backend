package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.user.RegisterDTO;
import com.example.demo.domain.user.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public User register(@RequestBody @Validated RegisterDTO u) {
		User newUser = new User(u.login(), u.password(), u.role());
		userRepository.save(newUser);
		return newUser;
	}

}
