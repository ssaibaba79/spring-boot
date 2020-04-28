package io.ss.spring.boot.ws.userservice;

import java.util.List;

import io.ss.spring.boot.ws.model.User;
import io.ss.spring.boot.ws.request.CreateUserRequest;
import io.ss.spring.boot.ws.request.UpdateUserRequest;

public interface UserService {
	
	public User createUser(CreateUserRequest request);
	
	public User updateUser(String userId, UpdateUserRequest request);
	
	public User findUserById(String id);
	
	public List<User> getAllUsers();
	
	public User removeUser(String id);

}
