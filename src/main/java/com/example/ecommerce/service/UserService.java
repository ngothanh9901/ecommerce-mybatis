package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.exception.DuplicateException;
import com.example.ecommerce.exception.NotFoundException;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.userMapper = Mappers.getMapper(UserMapper.class);
	}

	//GetAllUser
	public List<User> getListUser() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new NotFoundException("Không tìm thấy user nào");
		}
		return users;
	}

	//GetById
	public Optional<User> selectUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new NotFoundException("Không tìm thấy user với id: " + id);
		}
		return user;
	}

	//PostId
	public User createdUser(UserDto userDto) {
		if (userRepository.existsByUserName(userDto.getUsername())) {
			throw new DuplicateException("Tên xe đã tồn tại");
		}
		User user = userMapper.toUser(userDto);
		return userRepository.save(user);
	}
}

