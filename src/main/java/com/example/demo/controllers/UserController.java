package com.example.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requests.UserRequest;
import com.example.demo.responses.UserResponse;
import com.example.demo.services.UserService;
import com.example.demo.shared.dto.UserDto;

@RestController
@RequestMapping("/users") 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/{id}")
	public UserResponse getUser(@PathVariable String id) {
		
		UserDto userDto = userService.getUserByUserId(id);
		
		UserResponse userResponse = new  UserResponse();
		
		BeanUtils.copyProperties(userDto, userResponse);
		
		return userResponse;
	}
	
	@PostMapping
	public UserResponse addtUser(@RequestBody UserRequest userRequest) {
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		
		UserResponse userResponse = new UserResponse();
		
		
		
		BeanUtils.copyProperties(createUser, userResponse);
		
		return userResponse;
 
		
	}
	
	@PutMapping(path="/{id}" )
	public UserResponse updatetUser(@PathVariable String id,@RequestBody UserRequest userRequest) {
		
		
		
		 UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDto updateUser = userService.updateUser(id, userDto);
		
		UserResponse userResponse = new UserResponse();
		
		
		
		BeanUtils.copyProperties(updateUser, userResponse);
		
		return userResponse;
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was 	called";
	}

}
