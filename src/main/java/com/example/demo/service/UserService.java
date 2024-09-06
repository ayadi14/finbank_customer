package com.example.demo.service;

import java.util.List;
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

	public String createUser(UserDto userDto) {

		User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), "USER", true);
		if (userRepository.findByUsername(userDto.getUsername()) != null) {
			return "Username is already Registered";
		} else if (userRepository.findByEmail(userDto.getEmail()) != null) {
			return "Email is already Registered";
		} else {
			userRepository.save(user);
			return "user Registered";
		}
		
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


