package com.example.ecommerce.repository;

import com.example.ecommerce.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

	int insertUser(User user);

	int updateUser(User user);

	int deleteUserById(int userId);

	List<User> selectAllUser();

	User selectUserById(@Param("id") int userId);

	Optional<User> selectUserById();
}
