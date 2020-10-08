package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.UserException;
import com.example.demo.requests.UserRequest;
import com.example.demo.responses.ErreurMessages;
import com.example.demo.responses.UserResponse;
import com.example.demo.services.UserService;
import com.example.demo.shared.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) throws Exception {

		UserDto userDto = userService.getUserByUserId(id);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userDto, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<UserResponse> getAllUsers(@RequestParam(value = "page" , defaultValue = "1") int page,@RequestParam(value = "limit", defaultValue = "15") int limit){
		
		List<UserResponse> userResponse = new ArrayList<>();
		
		List<UserDto> users = userService.getUsers(page,limit);
		
		for (UserDto userDto:users) {
			UserResponse user = new UserResponse();
			BeanUtils.copyProperties(userDto, user);
			userResponse.add(user);
		}
		return userResponse;
		
	}
	

	@PostMapping(consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
		)
	public ResponseEntity<UserResponse> addtUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
		
		if(userRequest.getFirstName().isEmpty()) throw new UserException(ErreurMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto createUser = userService.createUser(userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(createUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponse> updatetUser(@PathVariable String id, @RequestBody UserRequest userRequest) throws Exception {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = userService.updateUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) throws Exception {

		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
