package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<?> getListUser() {
		return ResponseEntity.ok(userService.getListUser());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getCarById(@PathVariable Long id) {
		Optional<User> car = userService.getUserById(id);
		return new ResponseEntity<>(car.get(), HttpStatus.OK);
	}
//	@PutMapping("/users")

}
