package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.entity.Account;

@Service
	public class AccountService {
	    @Autowired
	    private AccountRepository accountRepository;

		public List<Account> getAllAccounts() {

			return accountRepository.findAll();
		}

}
