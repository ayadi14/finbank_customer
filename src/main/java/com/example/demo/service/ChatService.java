package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ChatRepository;
import com.example.demo.entity.Chat;
@Service
public class ChatService {
	
	 @Autowired
	    private ChatRepository chatRepository;

	public List<Chat> getAllChats() {
		// TODO Auto-generated method stub
		return null;
	}

}
