package com.dans.dansmultipro.service;

import com.dans.dansmultipro.model.UserProfile;
import com.dans.dansmultipro.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        return new User(userProfile.getUsername(), userProfile.getPassword(), new ArrayList<>());
    }
}
