package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoanRepository;
import com.example.demo.entity.Loan;

@Service
	public class LoanService {
	    private  LoanRepository loanRepository;

		public List<Loan> getAllLoans() {
			// TODO Auto-generated method stub
			return null;
		}

	
}

