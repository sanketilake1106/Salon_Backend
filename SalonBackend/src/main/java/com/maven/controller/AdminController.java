package com.maven.controller;

import com.maven.config.CustomUserDetailIMPL;
import com.maven.config.CustomUserDetails;
import com.maven.models.Admin;
import com.maven.services.AdminService;
import com.maven.services.impl.JwtService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
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
    private CustomUserDetailIMPL customUserDetailIMPL;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService service;


    public static class AuthRequest {
        public String username;
        public String password;
    }

    public static class AuthResponse {
        public String token;
        public AuthResponse(String token) { this.token = token; }
    }

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
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
            );

            final var userDetails = customUserDetailIMPL.loadUserByUsername(authRequest.username);
            final var jwt = service.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }



    @GetMapping("/")
    public String session(HttpSession session){
        return "SESSION Id: "+session.getId();
    }


}
