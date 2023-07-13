package com.example.ecommerce.repository;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

	int insertUser(UserDto userDto);

	int updateUser(User user);

	User selectUserById(int id);

	List<User> selectAllUser();

	boolean deleteUserById(int id);

	boolean insertUser(String name);

	User insertUser();

	boolean isExistsByName();
}
