package com.example.Spring.boot.Pdf.service;

import com.example.Spring.boot.Pdf.entity.User;
import com.example.Spring.boot.Pdf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listAll()
    {
        return userRepository.findAll();
    }

}
