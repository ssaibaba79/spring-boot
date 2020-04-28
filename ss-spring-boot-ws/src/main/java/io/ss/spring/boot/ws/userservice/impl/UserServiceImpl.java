package io.ss.spring.boot.ws.userservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ss.spring.boot.ws.model.User;
import io.ss.spring.boot.ws.repository.UserRepository;
import io.ss.spring.boot.ws.request.CreateUserRequest;
import io.ss.spring.boot.ws.request.UpdateUserRequest;
import io.ss.spring.boot.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	UserRepository userRepository;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(CreateUserRequest request) {
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastname());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		
		return userRepository.add(user);
	}

	@Override
	public User updateUser(String userId, UpdateUserRequest request) {
		User user = new User();
		user.setId(userId);
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastname());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		
		return userRepository.update(user);
	}

	@Override
	public User findUserById(String userId) {
		return userRepository.fetchById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.fetchAll();
	}

	@Override
	public User removeUser(String userId) {
		return userRepository.delete(userId);
	}

}
