package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
@Service
public class UserService {
	  @Autowired
	    private UserRepository userRepository;

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	public String createUser(UserDto userDto) {

//	User user = new User();
//	user.setUsername(userDto.getUsername());
//	user.setEmail(userDto.getEmail());
//	user.setPassword(userDto.getPassword());
//	user.setActive(false);
//	user.setRole("USER");	
	User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), "USER", false);
	if(userRepository.findByUsername(userDto.getUsername())!=null) {
		return "Username is already Registered";
	}
	else if(userRepository.findByEmail(userDto.getEmail())!=null) {
		return "Email is already Registered";
	}
	else {
		userRepository.save(user);
		return "user Registered";
	}
	}
}

