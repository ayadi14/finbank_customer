package com.example.demo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * Retrieve all accounts from the repository.
	 *
	 * @return a list of all accounts
	 */
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	/**
	 * Create a new account if no existing account with the same userId and
	 * accountType is found.
	 *
	 * @param accountDto the DTO containing account details
	 * @return a success message indicating the account creation result
	 */

	public String createAccount(AccountDto accountDto) {
		// Check if an account with the same userId and accountType exists
		if (accountRepository.existsByUserIdAndAccountType(accountDto.getUserId(), accountDto.getAccountType())) {
			return 
					"An account with this user ID and account type already exists.";
		}

		// Find the user by ID
		Optional<User> userOptional = userRepository.findById(accountDto.getUserId());
		if (!userOptional.isPresent()) {
			return "User with ID " + accountDto.getUserId() + " not found.";
		}

		Account account = new Account();
		account.setAccountType(accountDto.getAccountType());
		account.setBalance(BigDecimal.ZERO);
		account.setUser(userOptional.get());
		account.setAccountNumber(Long.valueOf(getAccountNumber()));

		// Save the new account
		Account createdAccount = accountRepository.save(account);

		if (createdAccount != null) {
			return createdAccount.getAccountType() + " account is created successfully.";
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create the account.");
		}
	}

	private String getAccountNumber() {
		String maxAccountNumber = accountRepository.findMaxAccountNumber();
		if (maxAccountNumber == null) {
			maxAccountNumber = "11111111111111";
		} else {
			// Use BigInteger for large account numbers
			BigInteger accountNumber = new BigInteger(maxAccountNumber);
			accountNumber = accountNumber.add(BigInteger.ONE);
			maxAccountNumber = accountNumber.toString();
		}
		return maxAccountNumber;
	}
}
