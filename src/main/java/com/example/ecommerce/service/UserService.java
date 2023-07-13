package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;

import java.util.List;


public interface UserService {

	User getUserById(int id);

	User createUser(UserDto userDto);

	int updateUser(int id, UserDto userDto);

	List<User> getListUser();

	void deleteUserById(int id);


}

