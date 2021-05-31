package com.unla.app.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.app.entities.Users;
import com.unla.app.repositories.IUserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
    IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users appUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
		
		Set grantList = new HashSet(); 
		
		return null;
	}

}
