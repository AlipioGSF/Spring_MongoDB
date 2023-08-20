package com.alipiogomes.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipiogomes.workshopmongodb.domain.User;
import com.alipiogomes.workshopmongodb.dto.UserDTO;
import com.alipiogomes.workshopmongodb.repositories.UserRepository;
import com.alipiogomes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	public User update(User updatedUser) {
		User user = findById(updatedUser.getId());
		updateData(user, updatedUser);
		return userRepository.save(user);
	}
	
	public void updateData(User user, User updatedUser) {
		user.setEmail(updatedUser.getEmail());
		user.setName(updatedUser.getName());
	}
}
