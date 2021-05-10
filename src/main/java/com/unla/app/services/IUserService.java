package com.unla.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unla.app.entities.User;


public interface IUserService {

	public List<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public void save ( User user);
	
	public User findOne(Long id);
	
	public void delete(Long id);
	

}
