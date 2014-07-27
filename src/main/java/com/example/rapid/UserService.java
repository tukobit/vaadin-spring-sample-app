package com.example.rapid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rapid.domain.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public User save(User user) 
	{
		repository.save(user);
		return user;
	}
	
	public User getUser(Long id)
	{
		return repository.findOne(id);
		
	}
	
	public List<User> getUsers()
	{
		return com.google.common.collect.Lists.newArrayList(repository.findAll());
	}

	public void remove(Long id) {
		repository.delete(id);
	}
}
