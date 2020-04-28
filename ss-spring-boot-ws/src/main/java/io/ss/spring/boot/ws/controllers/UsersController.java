package io.ss.spring.boot.ws.controllers;


import java.util.List;

import javax.validation.Valid;

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

import io.ss.spring.boot.ws.model.User;
import io.ss.spring.boot.ws.request.CreateUserRequest;
import io.ss.spring.boot.ws.request.UpdateUserRequest;
import io.ss.spring.boot.ws.userservice.UserService;

@RestController
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	UserService userService;
	

	/**
	 * Fetch All Users
	 * @param page
	 * @param limit
	 * @param sort
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page, 
			@RequestParam(value ="limit", defaultValue = "10", required = false) int limit,
			@RequestParam(value ="sort", defaultValue="byId", required = false) String sort) {
		
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	/**
	 * Fetch User By Id
	 * @param userId
	 * @return
	 */
	@GetMapping(path="/{userId}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		return ResponseEntity.ok( userService.findUserById(userId));
	}
	
	/**
	 * Create User
	 * Accepts and produces a JSON 
	 * Input Validation enabled 
	 * @param CreateUserRequest
	 * @return ResponseEntity<User>
	 */
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
		
	}
	
	/**
	 * Update user API
	 * @param userId
	 * @param request
	 * @return
	 */
	@PutMapping(path="/{userId}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, request));
	}
	
	/**
	 * Delete User API
	 * @param userId
	 * @return
	 */
	@DeleteMapping(path="/{userId}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		
		userService.removeUser(userId);
		return ResponseEntity.noContent().build();
	}
	
}
