package com.app.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dao.UserRoleDao;
import com.app.service.UserService;
import com.app.user.model.UserModel;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userRepository;
	@Autowired
	private UserRoleDao userRoleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(UserModel user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(new HashSet<>(userRoleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public UserModel findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
