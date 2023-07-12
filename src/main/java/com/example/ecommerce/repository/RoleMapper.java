package com.example.ecommerce.repository;

import com.example.ecommerce.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role")
    List<Role> getAllRole();
}
