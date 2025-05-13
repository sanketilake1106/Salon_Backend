package com.maven.services.impl;

import com.maven.Repository.UserRepository;
import com.maven.models.Admin;
import com.maven.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin login(Admin admin) {
        Admin loggedAdmin = userRepository.getUserByEmailAndPassword(admin.getEmail(), admin.getPassword());

        if(loggedAdmin !=null){
            return loggedAdmin;
        }
        else {
            return null;
        }
    }

    @Override
    public Admin addUser(Admin admin) {

        if(userRepository.findByEmail(admin.getEmail()).isEmpty()){
            return userRepository.save(admin);
        }else{
            return null;
        }
    }
}
