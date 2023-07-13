package com.example.ecommerce.controller;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static liquibase.repackaged.net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

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
	public ResponseEntity<User> selectUserById(@PathVariable Long id) {
		Optional<User> user = userService.selectUserById(id);
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createdUser(@RequestBody UserDto userDto) {
		User createdUser = userService.createdUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

//	@PutMapping("/users/{id}")
//	public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
//		Car updatedCar = carService.updateCar(id, carDto);
//		return new ResponseEntity<>(updatedCar, HttpStatus.OK);
//	}

//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<String> deleteCar(@PathVariable Long id) {
//		carService.deleteCar(id);
//		return new ResponseEntity<>("Đã xoá thành công", HttpStatus.OK);
//	}
}
