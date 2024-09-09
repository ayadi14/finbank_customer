package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Map<String, String> createUser(UserDto userDto) {
		Map<String, String> response = new HashMap<>();
		
		User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), "USER", true);
		if (userRepository.findByUsername(userDto.getUsername()) != null) {
			response.put("FAILED", "Username is already Registered");
		} else if (userRepository.findByEmail(userDto.getEmail()) != null) {
			response.put("FAILED", "Email is already Registered");
		} else {
			userRepository.save(user);
			response.put("SUCCESS", "user Registered");
		}
		return response;
		
	}

	public User updateUser(Long id, UserDto userDTO) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return userRepository.save(user); 
		
	}

	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found with id: " + id);
		}
		userRepository.deleteById(id);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
}


