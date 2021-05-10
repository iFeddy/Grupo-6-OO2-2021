package com.unla.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.app.entities.User;
import com.unla.app.repositories.IUserRepository;

@Service("userService")
public class UserServicesImpl implements IUserService {

	
	@Autowired
	@Qualifier("userRepository")
	private IUserRepository iuserRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		
		return (List<User>) iuserRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		return iuserRepository.findById(id).orElse(null);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return iuserRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(User user) {
		iuserRepository.save(user);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iuserRepository.deleteById(id);
	}

}
