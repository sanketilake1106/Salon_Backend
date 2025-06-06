package com.maven.services.jwt;

import com.maven.Repository.AdminRepository;
import com.maven.models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> user = adminRepository.getAdminByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No User Found!");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN" );
        return new User(user.get().getUsername(), user.get().getPassword(), Collections.singletonList(authority));
    }
}
