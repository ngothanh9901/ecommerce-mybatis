package com.example.ecommerce.controller;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getListUser() {
		List<User> users = userService.getListUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createdUser(@RequestBody UserDto userDto) {
		User createUser = userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserDto userDto) {
		int updateUser = userService.updateUser(id, userDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable int id) {
		userService.deleteUserById(id);
		return new ResponseEntity<>("Đã xoá thành công", HttpStatus.OK);
	}
}
