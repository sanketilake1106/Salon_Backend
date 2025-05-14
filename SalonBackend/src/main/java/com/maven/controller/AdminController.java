package com.maven.controller;

import com.maven.exception.InvalidCredentialsException;
import com.maven.models.Admin;
import com.maven.services.AdminService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void createAdmin(){
        Admin admin = new Admin();
        admin.setUserName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setContact("1234567890");
        admin.setPassword(passwordEncoder.encode("123"));
        adminService.addUser(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        return adminService.verify(admin);
    }

    @GetMapping("/")
    public String session(HttpSession session){
        return "SESSION Id: "+session.getId();
    }


}
