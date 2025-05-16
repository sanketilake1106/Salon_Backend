package com.maven.controller;

import com.maven.models.Admin;
import com.maven.services.AdminService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequestMapping("/admin")
@CrossOrigin("origins = http://localhost:4200")
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
    public ResponseEntity<String> login(@RequestBody Admin admin) {

        String token = adminService.verify(admin.getEmail(), admin.getPassword());

        if (!token.equals("Fail")) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



    @GetMapping("/")
    public String session(HttpSession session){
        return "SESSION Id: "+session.getId();
    }


}
