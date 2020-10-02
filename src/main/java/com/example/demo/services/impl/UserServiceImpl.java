package com.example.demo.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.UserEntity;
import com.example.demo.services.UserService;
import com.example.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	 UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {

		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptePassword("hbkdbdsbfhrbhskdfb");
		userEntity.setUserId("15");
		
		UserEntity newUser = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(newUser, userDto);
		
		
		return userDto;
	}

}
