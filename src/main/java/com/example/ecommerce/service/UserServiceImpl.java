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

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.userMapper = Mappers.getMapper(UserMapper.class);
	}

	//GetAllUser
	@Override
	public List<User> getListUser() {
		List<User> users = userRepository.selectAllUser();
		if (users.isEmpty()) {
			throw new NotFoundException("Không tìm thấy user nào!");
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user = userRepository.selectUserById(id);
		if (user == null) {
			throw new NotFoundException("Không tìm thấy user với id: " + id);
		}
		return user;
	}

	@Override
	public User createUser(UserDto userDto) {
		if (userRepository.insertUser(userDto.getName())) {
			throw new DuplicateException("Tên user đã tồn tại!");
		}
		User user = userMapper.toUser(userDto);
		return userRepository.insertUser();
	}

	@Override
	public int updateUser(int id, UserDto userDto) {
		User existingUser = userRepository.selectUserById(id);
		if (existingUser == null) {
			throw new NotFoundException("Không tìm thấy user với id: " + id);
		}
		existingUser.setName(userDto.getName());
		if (userRepository.isExistsByName()) {
			throw new DuplicateException("Tên user đã tồn tại");
		}
		User user = userMapper.toUser(userDto);
		return userRepository.insertUser(userDto);
	}

	@Override
	public void deleteUserById(int id) {
		if (!userRepository.deleteUserById(id)) {
			throw new NotFoundException("Không tìm thấy user với id: " + id);
		}
		userRepository.deleteUserById(id);
	}

}
