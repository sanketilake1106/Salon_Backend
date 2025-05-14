package com.maven.services;

import com.maven.exception.InvalidCredentialsException;
import com.maven.exception.UserNameAlreadyExistsException;
import com.maven.models.Admin;

public interface AdminService {

    String verify(Admin admin);

    Admin addUser(Admin admin);
}
