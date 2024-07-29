package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.user.AuthenticationDTO;
import com.example.demo.domain.user.LoginResponseDTO;
import com.example.demo.domain.user.RegisterDTO;
import com.example.demo.domain.user.User;
import com.example.demo.infra.security.TokenService;
import com.example.demo.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	TokenService tokenService;
	
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO u) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(u.login(), u.password());
		var auth = this.authenticationManager.authenticate(userNamePassword);
		
		var  token = tokenService.generateToken((User)auth.getPrincipal());
		
		
		return ResponseEntity.ok(new LoginResponseDTO(u.login(), token));
		
	}	
	
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO u) {
		if(this.userRepository.findByLogin(u.login()) != null) 
			return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(u.password());
		
		User newUser = new User(u.login(), encryptedPassword, u.role());
		userRepository.save(newUser);
		
		var userNamePassword = new UsernamePasswordAuthenticationToken(u.login(), u.password());
		var auth = this.authenticationManager.authenticate(userNamePassword);
		
		var  token = tokenService.generateToken((User)auth.getPrincipal());
		
		
		return ResponseEntity.ok(new LoginResponseDTO(u.login(), token));
		
	}
	
	

}
