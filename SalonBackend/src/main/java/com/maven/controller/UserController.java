package com.maven.controller;

import com.maven.exception.InvalidCredentialsException;
import com.maven.exception.UserNameAlreadyExistsException;
import com.maven.models.Admin;
import com.maven.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/salon")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void createAdmin() throws UserNameAlreadyExistsException {
        Admin admin = new Admin();
        admin.setUserName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setContact("1234567890");
        admin.setPassword(passwordEncoder.encode("123"));
        userService.addUser(admin);
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) throws InvalidCredentialsException {
        return userService.login(admin);
    }


}
