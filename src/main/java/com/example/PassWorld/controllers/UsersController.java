package com.example.PassWorld.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PassWorld.models.Users;
import com.example.PassWorld.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    UsersService usersService;

    public UsersController (UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers () {
        return usersService.getUsersList();
    }
    
    @GetMapping("/{id}")
    public Users getUserById (@PathVariable Long id) throws Exception {
        return usersService.finUserById(id);
    }
}
