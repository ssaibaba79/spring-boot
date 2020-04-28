package io.ss.spring.boot.ws.repository;

import java.util.List;

import io.ss.spring.boot.ws.model.User;

public interface UserRepository {

	public User add(User user);
	
	public User update(User user);
	
	public User fetchById(String id);
	
	public List<User> fetchAll();
	
	public User delete(String id);
}
