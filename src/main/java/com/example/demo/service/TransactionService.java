package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TransactionRepository;
import com.example.demo.entity.Transaction;

@Service
public class TransactionService {
	@Autowired
    private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
