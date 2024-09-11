package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.FixedDepositRepository;
import com.example.demo.dto.FixedDepositDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.FixedDeposit;

@Service
public class FixedDepositService {
	 @Autowired
	    private FixedDepositRepository fixedDepositRepository;
	 @Autowired
	    private AccountRepository accountRepository;

	public List<FixedDepositDto> getAllFixedDeposits() {
		// TODO Auto-generated method stub
		return null;
	}
	

//FixedDepositService.java

public String createFixedDepositByUser(FixedDepositDto dto) {
	
	Optional<Account> accountOptional  =  accountRepository.findByAccountNumber(dto.getAccountNumber());
	Account account = accountOptional.get();
	if(account == null) {
		 return "Account not found";
	}
	 if (!account.getAccountType().equalsIgnoreCase("Savings")) {
         return ("Only savings accounts are eligible for fixed deposits.");
     }
	  if (account.getBalance().compareTo(dto.getDepositAmount()) <= 0) {
		  return("Insufficient balance for the deposit");
	  }
	  FixedDeposit fixedDeposit = new FixedDeposit();
	  account.setBalance(account.getBalance().subtract(dto.getDepositAmount()));
      fixedDeposit.setAccount(account);
      fixedDeposit.setDepositAmount(dto.getDepositAmount());
      fixedDeposit.setCreatedOnDate(LocalDateTime.now());
      fixedDeposit.setMaturityDate(LocalDateTime.now().plusDays(dto.getDepositPeriod()));
      fixedDeposit.setInterestRate(dto.getRateOfIntrest());
      fixedDeposit.setCreatedby(account.getUser().getId());
      fixedDepositRepository.save(fixedDeposit);
      
	 
	return  "fixedDeposit created succcessfully";
	 

	}
	


public FixedDepositDto getFixedDepositById(Long id) {
	// TODO Auto-generated method stub
	return null;
}


public void deleteFixedDeposit(String id) {
	// TODO Auto-generated method stub
	
}


public FixedDepositDto updateFixedDeposit(String id, FixedDepositDto fixedDepositDTO) {
	// TODO Auto-generated method stub
	return null;
}

 // Other methods like getting all deposits, updating, deleting etc.
}
