package com.javaguides.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.EntityNotFoundException;
import com.javaguides.springboot.model.User;
import com.javaguides.springboot.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers(){ return userRepository.findAll();}

	@Transactional
	public void deleteUser(Long id) { userRepository.deleteUserById(id);}
	
	public User findUserById(Long id) {
		
		return userRepository.findUserById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id));
	}
	@Transactional
	public User findUserByuserName(String userName) {
		
		return userRepository.findUserByuserName(userName)
				.orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + userName));
	}
	
	public String validateRegisteredUser(String email, String password) {
		String name=null;
		
		for (User userRegister : userRepository.findAll()) {
			if(userRegister.getEmail().equals(email) && userRegister.getPassword().equals(password) ) {
				name = userRegister.getUserName();
				
			}
		}
		
		return name;
		
	}
}
