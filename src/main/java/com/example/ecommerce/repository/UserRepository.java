package com.example.ecommerce.repository;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

	boolean existsByUserName(String userName);
	boolean existsByUserNameAndIdNot(String userName, Long id);
	int insertUser(User user);

	int updateUser(Long id, User user);

	int deleteUserById(int userId);

	List<User> selectAllUser();

	Optional<User> selectUserById(Long id);

	User createdUser(UserDto userDto);
	Optional<User> findById(Long id);

	List<User> findAll();

	User save(User car);
}
