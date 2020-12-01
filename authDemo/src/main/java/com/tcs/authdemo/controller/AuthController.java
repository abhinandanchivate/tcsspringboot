package com.tcs.authdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.authdemo.payload.request.SignupRequest;
import com.tcs.authdemo.payload.response.MessageResponse;
import com.tcs.authdemo.repository.UserRepository;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/auth")
public class AuthController {

	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/signup")
	
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest ) {
		
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
		}
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use"));
		}
	}
}
