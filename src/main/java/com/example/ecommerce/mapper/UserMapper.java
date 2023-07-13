package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({
			@Mapping(source = "dto.name", target = "name"),
			@Mapping(source = "dto.email", target = "email"),
			@Mapping(source = "dto.username", target = "username"),
			@Mapping(source = "dto.password", target = "password")
	})
	User toUser(UserDto dto);

}
