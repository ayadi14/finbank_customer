package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FixedDepositRepository;
import com.example.demo.entity.FixedDeposit;
@Service
public class FixedDepositService {
	 @Autowired
	    private FixedDepositRepository fixedDepositRepository;

	public List<FixedDeposit> getAllFixedDeposits() {
		// TODO Auto-generated method stub
		return null;
	}

}
