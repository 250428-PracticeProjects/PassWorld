package com.example.PassWorld.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PassWorld.models.Users;
import com.example.PassWorld.repositories.UsersRepository;

@Service
public class UsersService {
    
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsersList() {return  usersRepository.findAll();}

    public Users finUserById (Long id) throws Exception{
        return usersRepository.findById(id).orElseThrow(() -> new Exception(id + "was not faound. Please check id or try another."));
    }
}
