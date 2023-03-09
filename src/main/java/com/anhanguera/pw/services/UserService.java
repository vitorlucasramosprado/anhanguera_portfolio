package com.anhanguera.pw.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.anhanguera.pw.entities.User;
import com.anhanguera.pw.exceptions.ResourceNotFoundException;
import com.anhanguera.pw.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	
	public List<User> findAll(){
		List<User> userList = userRepository.findAll();
		
		return userList;
	}
	
	public User findById(UUID id){
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User user){
		userRepository.save(user);
		
		return user;
	}
	
	public void delete(UUID id){
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
		}
	}
	
	public User update(UUID id, User user){
		try {
			User updatedUser = findById(id);
			updatedUser.setName(user.getName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setTelephone(user.getTelephone());
			updatedUser.setPassword(user.getPassword());
			
			return userRepository.save(updatedUser);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
		}
	}
	
	
}
