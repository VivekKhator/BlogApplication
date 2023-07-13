package com.spring.blogapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogapp.payloads.UserDto;
import com.spring.blogapp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUserDto = userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
		UserDto userDto = this.userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
//		List<UserDto> userDtos = userService.getAllUsers();
//		return new ResponseEntity<>(userDtos, HttpStatus.OK);
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
//		UserDto updatedUserDto = this.userService.updateUser(userDto, userId);
//		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);		
		return ResponseEntity.ok(this.userService.updateUser(userDto, userId));
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
//		return new ResponseEntity<>("User "+userId +" has been deleted", HttpStatus.OK);
		return new ResponseEntity<>(Map.of("message","User has been successfully deleted"),HttpStatus.OK);
	}
}
