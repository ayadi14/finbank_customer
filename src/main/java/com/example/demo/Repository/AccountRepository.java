package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT MAX(a.accountNumber) FROM Account a")
	String findMaxAccountNumber();

	boolean existsByUserIdAndAccountType(Long userId, String accountType);

	Optional<Account> findByAccountNumber(Long accountNumber);
}
