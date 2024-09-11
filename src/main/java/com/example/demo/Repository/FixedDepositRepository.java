package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;
import com.example.demo.entity.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit,Long> {

	

//AccountRepository.java
// Optional<Account> findByUserId(Long userId);
}
