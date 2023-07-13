package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface UserMapper {
	User toUser(UserDto dto);

}
