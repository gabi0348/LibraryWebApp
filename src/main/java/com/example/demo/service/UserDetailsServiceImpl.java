package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client appClient =
                userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));

        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appClient.getAuthority().getAuthority());
        grantList.add(grantedAuthority);

        UserDetails user = (UserDetails) new User(appClient.getUsername(), appClient.getPassword(), grantList);
        return user;
    }
}