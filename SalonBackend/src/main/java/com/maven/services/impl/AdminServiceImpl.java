package com.maven.services.impl;

import com.maven.Repository.AdminRepository;
import com.maven.models.Admin;
import com.maven.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService service;


    @Override
    public String verify(String email, String password) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        if (authentication.isAuthenticated()) {
            return service.generateToken(email);
        }
        return "Fail";
    }

    @Override
    public Admin addUser(Admin admin) {

        if(adminRepository.findByEmail(admin.getEmail()).isEmpty()){
            return adminRepository.save(admin);
        }else{
            return null;
        }
    }
}
