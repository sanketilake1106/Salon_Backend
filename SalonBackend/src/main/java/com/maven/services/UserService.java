package com.maven.services;

import com.maven.exception.InvalidCredentialsException;
import com.maven.exception.UserNameAlreadyExistsException;
import com.maven.models.Admin;

import javax.naming.NameAlreadyBoundException;

public interface UserService {

    Admin login(Admin admin) throws InvalidCredentialsException;

    Admin addUser(Admin admin) throws UserNameAlreadyExistsException;
}
