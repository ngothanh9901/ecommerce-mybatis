package com.example.ecommerce.controller;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;
    @GetMapping("/")
    public List<Role> getAllRole(){
        return roleService.getAllRoles();
    }
}
