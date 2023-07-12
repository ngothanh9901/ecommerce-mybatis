package com.example.ecommerce.service;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.repository.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class RoleService {
    private  RoleMapper roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.getAllRole();
    }
}
