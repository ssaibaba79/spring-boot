package io.ss.spring.boot.ws.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.ss.spring.boot.ws.exception.UserServiceException;
import io.ss.spring.boot.ws.model.User;

@Service
public class InMemoryUserRepository implements UserRepository {
	
	private Map<String, User> store = new HashMap<>();
	
	
	@Override
	public User add(User user) {
		
		if(user == null) throw new IllegalArgumentException("User cannot be null");
		
		user.setId(UUID.randomUUID().toString());
		store.put(user.getId(),  user);
		
		return user;
	}
	
	@Override
    public User update(User user) {
    	if(user == null || user.getId() == null) throw new IllegalArgumentException("User cannot be null");
    	if(!store.containsKey(user.getId())) throw new UserServiceException("User Id "+ user.getId()  +" is not a valid user", UserServiceException.USER_NOT_FOUND);
    	
    	User usr = store.get(user.getId());
    	usr.copyFrom(user);
    	return store.put(usr.getId(), usr);
    }
	
    @Override
	public User delete(String id) {
		if(id == null) throw new IllegalArgumentException("Id cannot be null");
		if(!store.containsKey(id)) throw new UserServiceException("User Id "+ id  +" is not a valid user", UserServiceException.USER_NOT_FOUND);
		return store.remove(id);
	}
	
	@Override
	public User fetchById(String id) {
		
		if(id == null) throw new IllegalArgumentException("Id cannot be null");
		if(!store.containsKey(id)) throw new UserServiceException("User Id "+ id  +" is not a valid user", UserServiceException.USER_NOT_FOUND);
		return store.get(id);
	}

	@Override
	public List<User> fetchAll() {
		return store.values().stream()
                .collect(Collectors.toList());
	}
		
	
}
