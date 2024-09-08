package com.example.demo.service;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.TransactionRepository;
import com.example.demo.dto.TransactionMessageDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    public static final Long BANK_ACCOUNT = 0L;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

	public String withdrawAmoutFromAccount(Long fromAccountId, BigDecimal amount) {
		// TODO Auto-generated method stub
		return withdraw(fromAccountId, amount);
	}

	public String depositAmountToAccount(Long toAccountId, BigDecimal amount) {
		// TODO Auto-generated method stub
		return deposit(toAccountId, amount);
	}
    @Transactional
    public String deposit(Long accountNumber, BigDecimal amount) {
        Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setBalance(account.getBalance().add(amount));
            accountRepository.save(account);

            // Record transaction only if status is COMPLETED
            String transactionId = createTransaction(amount, "DEPOSIT", "COMPLETED", null, accountNumber);
            
            return transactionMessage(new TransactionMessageDto(transactionId, new Date().toString(),BANK_ACCOUNT.toString(), accountNumber.toString(), "Deposited Successfully", "DEPOSIT", "SUCCESS", "1"));
               } else {
        	 return transactionMessage(new TransactionMessageDto(null, new Date().toString(),BANK_ACCOUNT.toString(), accountNumber.toString(), "ACCOUNT NOT FOUND", "DEPOSIT", "Failed", "0"));
             
        }
    }

    @Transactional
    public String withdraw(Long accountNumber, BigDecimal amount) {
        Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            if (account.getBalance().compareTo(amount) >= 0) {
                account.setBalance(account.getBalance().subtract(amount));
                accountRepository.save(account);
                String transactionId = createTransaction(amount, "WITHDRAWAL", "COMPLETED", accountNumber, BANK_ACCOUNT);
                return transactionMessage(new TransactionMessageDto(transactionId, new Date().toString(), accountNumber.toString(),BANK_ACCOUNT.toString(), "Debited successfully", "WITHDRAW", "SUCCESS", "1"));
                
            } else {
                // No transaction record created on insufficient funds
            	return transactionMessage(new TransactionMessageDto(null, new Date().toString(), accountNumber.toString(),BANK_ACCOUNT.toString(), "INSUFFICENT FUND", "WITHDRAW", "Failed", "1"));
            	    }
        } else {
        	System.out.println("account no");
            // No transaction record created if account not found
            return transactionMessage(new TransactionMessageDto(null, new Date().toString(), accountNumber.toString(),BANK_ACCOUNT.toString(), "ACCOUNT NOT FOUND", "WITHDRAW", "Failed", "0"));
        }
    }

    private String transactionMessage(TransactionMessageDto transactionMessageDto) {
		return transactionMessageDto.toString();
	}

	@Transactional
    public String transfer(Long fromAccountNumber, Long toAccountNumber, BigDecimal amount) {
        try {
            // Perform the withdrawal
            String withdrawMessage = withdraw(fromAccountNumber, amount);
            if (!withdrawMessage.contains("SUCCESS")) {
                // If withdrawal fails, return the failure message and do not create a transaction
                return withdrawMessage;
            }

            // Perform the deposit
            String depositMessage = deposit(toAccountNumber, amount);
            if (!depositMessage.contains("SUCCESS")) {
                // If deposit fails, rollback the transaction
               return depositMessage;
            }

            // Record transaction only if status is COMPLETED
            String transactionId = createTransaction(amount, "TRANSFER", "COMPLETED", fromAccountNumber, toAccountNumber);
            return transactionId + withdrawMessage + depositMessage;
        } catch (IllegalArgumentException e) {
            // No transaction record created if any part of the transfer fails
            return transactionMessage(null);
        }
    }

    private String createTransaction(BigDecimal amount, String type, String status, Long fromAccountNumber, Long toAccountNumber) {
            Transaction transaction = new Transaction();
            transaction.setTransactionType(type);
            transaction.setStatus(status);
            transaction.setAmount(amount);
            transaction.setFromAccountNumber(fromAccountNumber);
            transaction.setToAccountNumber(toAccountNumber);
            transaction.setTransactionDate(java.time.LocalDateTime.now());

            return transactionRepository.save(transaction).getId().toString();
       
    }

   

   

}
