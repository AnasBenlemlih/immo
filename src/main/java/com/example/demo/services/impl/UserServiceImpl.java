package com.example.demo.services.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.UserEntity;
import com.example.demo.services.UserService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	Utils util;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	@Override
	public UserDto createUser(UserDto user) {
		
	 	UserEntity checkUser = userRepository.findByEmail(user.getEmail());
	 	
	 	if (checkUser != null) throw new RuntimeException("User Already Exists !! ");  
	 		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptePassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userEntity.setUserId(util.generateUserId(32));
		
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(newUser, userDto);
		
		
		return userDto;
	}

}
