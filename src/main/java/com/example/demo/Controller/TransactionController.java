package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @PutMapping("withdraw")
    public String withdrawAmoutFromAccount(@RequestBody TransactionDto tdo) {
        return transactionService.withdrawAmoutFromAccount(tdo.getFromAccountId(),tdo.getAmount());
    }
    
    @PutMapping("transfer")
    public String transerAmountFromAnAccountToAnotherAccount(@RequestBody TransactionDto tDto) {
        return transactionService.transfer(tDto.getFromAccountId(), tDto.getToAccountId(), tDto.getAmount());
    }

  

    @PutMapping("deposit")
    public String depositAmoutToAccount(@RequestBody TransactionDto tDto) {
    	return transactionService.depositAmountToAccount(tDto.getToAccountId(), tDto.getAmount());
    }
}
